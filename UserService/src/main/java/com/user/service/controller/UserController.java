package com.user.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.entities.User;
import com.user.service.payloads.ApiResponse;
import com.user.service.payloads.UserDTO;
import com.user.service.services.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	
	@PostMapping("/")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userdto){
		return new ResponseEntity<UserDTO>(userService.createUser(userdto), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers(User user){
		return new ResponseEntity<List<UserDTO>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/{userID}")
	public ResponseEntity<UserDTO> getSingleUser(@PathVariable String userID){
		return new ResponseEntity<UserDTO>(userService.getSingleUser(userID), HttpStatus.OK);
	}
	
	@DeleteMapping("/{userID}")
	public ResponseEntity<ApiResponse> saveUser(@PathVariable String userID){
			userService.deleteUser(userID);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Sucessfully", true) , HttpStatus.OK);
	}
	
	@PutMapping("/{userID}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody User user, @PathVariable String userID){
		return new ResponseEntity<UserDTO>(userService.updateUser(user, userID), HttpStatus.OK);
	}
	
	

}
