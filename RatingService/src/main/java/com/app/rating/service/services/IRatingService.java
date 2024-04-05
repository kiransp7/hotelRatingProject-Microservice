package com.app.rating.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.rating.service.entities.Rating;
import com.app.rating.service.payloads.RatingDTO;



@Service
public interface IRatingService {

	//create Ratings
	RatingDTO createRating(Rating rating);
	
	//create Multiple Ratings
	List<RatingDTO> createMultipleRatings(List<Rating> ratings);
	
	
	//get all Ratings
	List<RatingDTO> getAllRatings();
	
	
	//get all Ratings by user_id
	List<RatingDTO> getAllRatingByUserID(String userID);
	
	
	//get all Ratings by hotel_id
	List<RatingDTO> getAllRatingByHotelID(String hotelID);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
