package com.app.rating.service.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RatingDTO {
	
	private String id;

	private String userId;

	private String hotelId;

	private Integer rating;

	private String feedback;
	
	

}
