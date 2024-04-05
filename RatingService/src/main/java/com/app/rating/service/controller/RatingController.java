package com.app.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.rating.service.entities.Rating;
import com.app.rating.service.payloads.RatingDTO;
import com.app.rating.service.services.IRatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private IRatingService ratingService;
	
	@PostMapping("/")
	public ResponseEntity<RatingDTO> saveRating(@RequestBody Rating rating){
		return new ResponseEntity<RatingDTO>(ratingService.createRating(rating), HttpStatus.CREATED);
	}
	
	
	@PostMapping("/multiple")
	public ResponseEntity<List<RatingDTO>> saveRating(@RequestBody List<Rating> ratings){
		return new ResponseEntity<List<RatingDTO>>(ratingService.createMultipleRatings(ratings), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<RatingDTO>> saveUser(){
		return new ResponseEntity<List<RatingDTO>>(ratingService.getAllRatings(), HttpStatus.OK);
	}
	
	@GetMapping("/users/{userID}")
	public ResponseEntity<List<RatingDTO>> getAllRatingByUserID(@PathVariable String userID){
		return new ResponseEntity<List<RatingDTO>>(ratingService.getAllRatingByUserID(userID), HttpStatus.OK);
	}
	
	
	@GetMapping("/hotels/{hotelID}")
	public ResponseEntity<List<RatingDTO>> getAllRatingByHotelID(@PathVariable String hotelID){
		return new ResponseEntity<List<RatingDTO>>(ratingService.getAllRatingByHotelID(hotelID), HttpStatus.OK);
	}
	
	
	
	

}
