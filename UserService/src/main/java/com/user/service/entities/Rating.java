package com.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rating {
	
	private String id;

	private String userId;

	private String hotelId;

	private Integer rating;

	private String feedback;
	
	private Hotel hotel;
	

}
