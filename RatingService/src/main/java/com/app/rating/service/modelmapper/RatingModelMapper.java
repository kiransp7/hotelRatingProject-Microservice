package com.app.rating.service.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.rating.service.entities.Rating;
import com.app.rating.service.payloads.RatingDTO;


@Component
public class RatingModelMapper {

	@Autowired
	private ModelMapper modelMapper;

	
	// RatingDTO to Rating
	public Rating ratingdtoToRating(RatingDTO ratingDto) {
		
		return modelMapper.map(ratingDto, Rating.class);
	}
	
	// Rating to RatingDTO
	public RatingDTO ratingToRatingdto(Rating rating) {
		
		return modelMapper.map(rating, RatingDTO.class);
	}
	
	
}

