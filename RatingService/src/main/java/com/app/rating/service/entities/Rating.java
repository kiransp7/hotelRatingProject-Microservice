package com.app.rating.service.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document("users_ratings")
public class Rating {

	@Id
	@Column(name = "rid")
	private String id;

	private String userId;

	private String hotelId;

	private Integer rating;

	private String feedback;

}
