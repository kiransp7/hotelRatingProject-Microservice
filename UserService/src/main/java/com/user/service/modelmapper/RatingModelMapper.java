package com.user.service.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.user.service.entities.Rating;
import com.user.service.payloads.RatingDTO;

public class RatingModelMapper {
	
	
	@Autowired
	private ModelMapper modelMapper;

	
	// UserDTO to User
	public Rating ratingdtoToRating(RatingDTO ratingDto) {
		
		return modelMapper.map(ratingDto, Rating.class);
	}
	
	// User to UserDTO
	public RatingDTO ratingToRatingdto(Rating rating) {
		
		return modelMapper.map(rating, RatingDTO.class);
	}

}
