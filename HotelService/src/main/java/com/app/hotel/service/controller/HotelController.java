package com.app.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.hotel.service.entities.Hotel;
import com.app.hotel.service.payload.ApiResponse;
import com.app.hotel.service.payload.HotelDTO;
import com.app.hotel.service.services.IHotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	


	@Autowired
	private IHotelService hotelService;

	@PostMapping("/")
	public ResponseEntity<HotelDTO> createHotel(@RequestBody Hotel hotel) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
	}

	@GetMapping("/")
	public ResponseEntity<List<HotelDTO>> getAllHotels() {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotels());
	}

	@GetMapping("/{hotelID}")
	public ResponseEntity<HotelDTO> getSingleHotels(@PathVariable String hotelID) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getSingleHotel(hotelID));
	}

	@DeleteMapping("/{hotelID}")
	public ResponseEntity<ApiResponse> deleteHotel(@PathVariable String hotelID) {
		hotelService.deleteHotel(hotelID);
		return ResponseEntity.status(HttpStatus.OK)
				.body(ApiResponse.builder()
						.message("Hotel Deleted Sucessfully..")
						.sucess(true)
						.build());
	}
	
	@PutMapping("/{hotelID}")
	public ResponseEntity<HotelDTO> updateHotel(@RequestBody Hotel hotel , @PathVariable String hotelID) {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.updateHotel(hotel, hotelID));
	}
	
	
	
	
	
	
	
	
	
	
	
}
