package com.user.service.payloads;

import java.util.ArrayList;
import java.util.List;

import com.user.service.entities.Rating;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
	
	private String userId;
	
	private String name;
	
	private String email;
	
	private String about;
	
	private List<Rating> ratings = new ArrayList<>();
	
	
	

}
