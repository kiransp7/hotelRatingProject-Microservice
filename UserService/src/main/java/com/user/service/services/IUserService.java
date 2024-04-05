package com.user.service.services;

import java.util.List;

import com.user.service.entities.User;
import com.user.service.payloads.UserDTO;

public interface IUserService {
	
	//Create
	UserDTO createUser(UserDTO userdto);
	
	
	//getAllUsers
	List<UserDTO> getAllUsers();
	
	
	//get Single user on UserID
	UserDTO getSingleUser(String userId);
	
	//Delete User
	void deleteUser(String userId);
	
	//update User
	UserDTO updateUser(User user, String userId);


	
	
	
	
	
	

}
