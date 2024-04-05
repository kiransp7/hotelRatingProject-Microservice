package com.app.rating.service.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.rating.service.entities.Rating;
import com.app.rating.service.modelmapper.RatingModelMapper;
import com.app.rating.service.payloads.RatingDTO;
import com.app.rating.service.repository.RatingRepository;
import com.app.rating.service.services.IRatingService;

@Service
public class RatingServiceImpl implements IRatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private RatingModelMapper ratingModelMapper;
	
	
	@Override
	public RatingDTO createRating(Rating rating) {
		Rating saveRating = ratingRepository.save(rating);
		return ratingModelMapper.ratingToRatingdto(saveRating);
	}
	
	

	@Override
	public List<RatingDTO> createMultipleRatings(List<Rating> ratings) {
		
		List<Rating> allSavedRatings = ratingRepository.saveAll(ratings);
		
		List<RatingDTO> allRatingsDtos = allSavedRatings.stream().map(rating -> ratingModelMapper.ratingToRatingdto(rating)).collect( Collectors.toList());
		
		return allRatingsDtos;
	}
	
	

	
	@Override
	public List<RatingDTO> getAllRatings() {
		
		List<Rating> allRatings = ratingRepository.findAll();
		
		List<RatingDTO> ratingDtoList = new ArrayList<>();
		for(Rating r : allRatings) {
			ratingDtoList.add(ratingModelMapper.ratingToRatingdto(r));
		}
		
		return ratingDtoList;
	}

	
	@Override
	public List<RatingDTO> getAllRatingByUserID(String userID) {
		List<Rating> findratingByUserid = ratingRepository.findByUserId(userID);
		
		List<RatingDTO> ratingByUserUD = new ArrayList<>();
		for(Rating r : findratingByUserid) {
			ratingByUserUD.add(ratingModelMapper.ratingToRatingdto(r));
		}
		
		return ratingByUserUD;
	}

	
	@Override
	public List<RatingDTO> getAllRatingByHotelID(String hotelID) {
		List<Rating> findRatingByHotelid = ratingRepository.findByHotelId(hotelID);
		
		List<RatingDTO> ratingByHotelID = new ArrayList<>();
		for(Rating r : findRatingByHotelid) {
			ratingByHotelID.add(ratingModelMapper.ratingToRatingdto(r));
		}
		
		return ratingByHotelID;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
