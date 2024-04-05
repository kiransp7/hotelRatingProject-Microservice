package com.app.rating.service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.rating.service.entities.Rating;


@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {
	
	
	//get all Ratings by user_id
	List<Rating> findByUserId(String userId);
	
	
	//get all Ratings by hotel_id
	List<Rating> findByHotelId(String hotelId);
	
	

}
