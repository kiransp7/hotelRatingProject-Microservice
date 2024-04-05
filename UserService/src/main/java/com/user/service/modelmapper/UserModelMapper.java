package com.user.service.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.service.entities.User;
import com.user.service.payloads.UserDTO;

@Component
public class UserModelMapper {

	@Autowired
	private ModelMapper modelMapper;

	
	// UserDTO to User
	public User userdtoToUser(UserDTO userDto) {
		
		return modelMapper.map(userDto, User.class);
	}
	
	// User to UserDTO
	public UserDTO userToUserdto(User user) {
		
		return modelMapper.map(user, UserDTO.class);
	}
	
	
	
	

}
