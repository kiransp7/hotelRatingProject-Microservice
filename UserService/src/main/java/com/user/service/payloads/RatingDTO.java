package com.user.service.payloads;

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
public class RatingDTO {
	
	private String id;

	private String userId;

	private String hotelId;

	private Integer rating;

	private String feedback;

}
