package com.user.service.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.exception.ResourceNotFound;
import com.user.service.external.services.IHotelService;
import com.user.service.external.services.IRatingService;
import com.user.service.modelmapper.UserModelMapper;
import com.user.service.payloads.UserDTO;
import com.user.service.repository.UserRepository;
import com.user.service.services.IUserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserModelMapper userModelMapper;
	
	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IRatingService ratingService;
	
	
	
	private final WebClient webClient;

	 	@Autowired
	    public UserServiceImpl(WebClient.Builder webClient) {
	        this.webClient = webClient.build();
	    }

	@Override
	public UserDTO createUser(UserDTO userdto) {
		// Generate Unique userID
		String randomUserID = UUID.randomUUID().toString();
		userdto.setUserId(randomUserID);
		
		User user = userModelMapper.userdtoToUser(userdto); //MM
		User savedUser = userRepository.save(user);
		
		for(Rating rat : userdto.getRatings()) {
			rat.setUserId(user.getUserId());
		}
		
		List<Rating> createMultipleRating = ratingService.createMultipleRating(userdto.getRatings());
		
		UserDTO userdtos = userModelMapper.userToUserdto(savedUser);
		
		userdtos.setRatings(createMultipleRating);
	
		return userdtos;
	}
	

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		
		
		List<UserDTO> allUserDTO = allUsers.stream().map(user -> userModelMapper.userToUserdto(user)).collect(Collectors.toList());
		
		allUserDTO.forEach( userDto  ->  {
			     List<Rating> listOfRatings = ratingService.getAllRatings(userDto.getUserId());

				 listOfRatings.forEach(rating -> {
					 Hotel hotel = hotelService.getHotels(rating.getHotelId());
					 rating.setHotel(hotel);
				 });
				 userDto.setRatings(listOfRatings);
		});
		
			log.info("User with Ratings :-  {}", allUserDTO);		

		return allUserDTO;
	}
	
	
	@Override
	public UserDTO getSingleUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFound("User", userId));

			 List<Rating> listOfRatings = webClient.get()
												 .uri("http://RATING-SERVICE/ratings/users/"+user.getUserId())
												 .accept(MediaType.APPLICATION_JSON)
												 .retrieve()
												 .bodyToFlux(Rating.class)
												 .collectList()
												 .block();
			 
			 UserDTO userDto = userModelMapper.userToUserdto(user);
			 
			 log.info("Ratings fetch from  User :-  {}", listOfRatings);

			 
		for(Rating r : listOfRatings) {
					
			Hotel hotel = webClient
								.get().uri("http://HOTEL-SERVICE/hotels/"+r.getHotelId())
								.accept(MediaType.APPLICATION_JSON)
								.retrieve()
								.bodyToFlux(Hotel.class)
								.blockLast();
						 
				 r.setHotel(hotel);
			 }
			 
			 userDto.setRatings(listOfRatings);
			 
		return userDto;
	}
	

	@Override
	public void deleteUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFound("User", userId));
		userRepository.delete(user);
		log.debug("User deleted : {}", user);
	}

	@Override
	public UserDTO updateUser(User user, String userId) {
		
		User foundUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFound("User", userId));
		
		foundUser.setName(user.getName());
		foundUser.setEmail(user.getEmail());
		foundUser.setAbout(user.getAbout());
		User updatedUser = userRepository.save(foundUser);
		
		return userModelMapper.userToUserdto(updatedUser);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
