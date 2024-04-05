package com.app.hotel.service.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hotel.service.entities.Hotel;
import com.app.hotel.service.exception.ResourceNotFound;
import com.app.hotel.service.modelmapper.HotelModelMapper;
import com.app.hotel.service.payload.HotelDTO;
import com.app.hotel.service.repository.HotelRepository;
import com.app.hotel.service.services.IHotelService;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private HotelModelMapper hotelModelMapper;

	
	@Override
	public HotelDTO createHotel(Hotel hotel) {
		// Generate Unique hotelID
		String randomHotelID = UUID.randomUUID().toString();
		hotel.setHotelId(randomHotelID);
		Hotel saveHotel = hotelRepository.save(hotel);
		return hotelModelMapper.hotelToHoteldto(saveHotel);
	}

	@Override
	public List<HotelDTO> getAllHotels() {
		List<Hotel> allHotels = hotelRepository.findAll();
		List<HotelDTO> allHotelDto = allHotels.stream().map(hotel -> hotelModelMapper.hotelToHoteldto(hotel)).collect(Collectors.toList());
		return allHotelDto;
	}

	@Override
	public HotelDTO getSingleHotel(String hotelID) {
		Hotel hotel = hotelRepository.findById(hotelID).orElseThrow(() -> new ResourceNotFound("Hotel", hotelID));
		return hotelModelMapper.hotelToHoteldto(hotel);
	}

	@Override
	public void deleteHotel(String hotelID) {
		Hotel hotel = hotelRepository.findById(hotelID).orElseThrow(() -> new ResourceNotFound("Hotel", hotelID));
		hotelRepository.delete(hotel);
	}

	@Override
	public HotelDTO updateHotel(Hotel hotel, String hotelID) {
		Hotel foundHotel = hotelRepository.findById(hotelID).orElseThrow(() -> new ResourceNotFound("Hotel", hotelID));
		foundHotel.setName(hotel.getName());
		foundHotel.setLocation(hotel.getLocation());
		foundHotel.setAbout(hotel.getAbout());
		
		Hotel saveHotel = hotelRepository.save(foundHotel);
		return hotelModelMapper.hotelToHoteldto(saveHotel);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
