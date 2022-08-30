package com.esolutions.microservice.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esolutions.microservice.models.UserDTO;
import com.esolutions.microservice.services.UserMockedData;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	UserMockedData userMockedData = UserMockedData.getInstance();

	// Get all users
	@GetMapping()
	public List<UserDTO> getAllUsers() {
		return userMockedData.getAllUsers();
	}
	
	// Get an user by id
	@GetMapping("{id}")
	public UserDTO getUserById(@PathVariable() String id) {
		int userId = Integer.parseInt(id);
		return userMockedData.getUserById(userId);
	}
	
	// Search for search term
	@PostMapping("/search")
	public List<UserDTO> search(@RequestBody Map<String, String> body) {
		String searchTerm = body.get("searchTerm");
		System.out.println(searchTerm);
		return userMockedData.searchUsers(searchTerm);
	}
	
	// Create user
	@PostMapping() 
	public UserDTO create(@RequestBody Map<String, String> body) {
		String name = body.get("name");
		String lastname = body.get("lastname");
		UserDTO user = new UserDTO();
		user.setName(name);
		user.setLastname(lastname);
		return userMockedData.createUser(user);
	}
	
	// update user
	@PutMapping("{id}") 
	public UserDTO create(@PathVariable() String id, @RequestBody Map<String, String> body) {
		int userId = Integer.parseInt(id);
		String name = body.get("name");
		String lastname = body.get("lastname");
		UserDTO user = new UserDTO();
		user.setName(name);
		user.setLastname(lastname);
		return userMockedData.updateUser(user, userId);
	}
	
	
	// delete user by id
	@DeleteMapping("{id}")
	public boolean delete(@PathVariable() String id) {
		int userId = Integer.parseInt(id);
		return userMockedData.deleteUser(userId);
	}
}
