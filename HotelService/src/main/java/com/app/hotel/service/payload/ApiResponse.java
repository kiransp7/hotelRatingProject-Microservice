package com.app.hotel.service.payload;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@NoArgsConstructor
public class ApiResponse {
	
	String message;
	boolean sucess;

	public ApiResponse(String message, boolean sucess) {
		this.message = message;
		this.sucess = sucess;
	}
	
	
	

}
