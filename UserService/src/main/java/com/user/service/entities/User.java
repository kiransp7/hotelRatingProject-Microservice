package com.user.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "micro_user")
public class User{
	
	@Id
	private String userId;
	
	
	@Column(length = 15)
	private String name;
	
	@Column(length = 25)
	private String email;
	
	private String about;
	
	
}
