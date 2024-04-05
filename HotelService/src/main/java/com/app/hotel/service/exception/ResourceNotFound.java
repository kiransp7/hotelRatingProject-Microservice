package com.app.hotel.service.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@SuppressWarnings("all")
public class ResourceNotFound extends RuntimeException {
	
	String resource;
	String hotelId;
	
	public ResourceNotFound(String resource, String hotelId) {
		super(resource+ " Not Found ID : " +hotelId);
		this.resource = resource;
		this.hotelId = hotelId;
	}
	
	
	

}
