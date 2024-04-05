package com.user.service.payloads;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Builder
public class ApiResponse {
	
	String message;
	boolean success;
	
	public ApiResponse(String message, boolean success) {
		this.message = message;
		this.success = success;
	}
	
	
	

}
