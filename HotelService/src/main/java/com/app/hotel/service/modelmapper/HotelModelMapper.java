package com.app.hotel.service.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.hotel.service.entities.Hotel;
import com.app.hotel.service.payload.HotelDTO;

@Component
public class HotelModelMapper {

	@Autowired
	private ModelMapper modelMapper;

	
	// Hotel to HotelDTO
	public HotelDTO hotelToHoteldto(Hotel hotel) {

		return modelMapper.map(hotel, HotelDTO.class);
	}

	
	// HotelDTO to Hotel
	public Hotel hoteldtoToHotel(HotelDTO hotelDto) {
		return modelMapper.map(hotelDto, Hotel.class);
	}

	
	
	
	
}
