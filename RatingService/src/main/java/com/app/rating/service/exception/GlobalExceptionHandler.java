package com.app.rating.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.rating.service.payloads.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFound resourceNotFound){
		return new ResponseEntity<ApiResponse>(ApiResponse
					.builder()
					.message(resourceNotFound.getMessage())
					.success(false)
					.build(), HttpStatus.NOT_FOUND);
	}
	

}
