package com.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.service.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface IHotelService {
	
	@GetMapping("hotels/{hotelId}")
	Hotel getHotels(@PathVariable(name = "hotelId") String hotelId);
	
	@PostMapping("hotels/")
	Hotel createHotel(@RequestBody Hotel hotel);
	
	
	

}
