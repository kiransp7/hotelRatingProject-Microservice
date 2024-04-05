package com.user.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.service.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface IRatingService {
	
	@GetMapping("ratings/users/{userId}")
	List<Rating> getAllRatings(@PathVariable(name = "userId") String userId);
	
	@PostMapping("/ratings/multiple")
	List<Rating> createMultipleRating(@RequestBody List<Rating> rating);
	

}
