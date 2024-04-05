package com.app.hotel.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.hotel.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> resourceNotFoundHandler(ResourceNotFound ex) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(ApiResponse
						.builder()
						.message(ex.getMessage())
						.sucess(false)
						.build());
	}

}
