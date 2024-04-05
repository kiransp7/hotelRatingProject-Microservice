package com.app.hotel.service.services;

import java.util.List;

import com.app.hotel.service.entities.Hotel;
import com.app.hotel.service.payload.HotelDTO;

public interface IHotelService {
	
	
	// create hotel
	HotelDTO createHotel(Hotel hotel);
	
	
	// get all hotel
	List<HotelDTO> getAllHotels();
	
	
	// get single hotel
	HotelDTO getSingleHotel(String hotelID);
	
	// delete hotel
	void deleteHotel(String hotelID);
	
	// update hotel
	HotelDTO updateHotel(Hotel hotel, String hotelID);
	
	

}
