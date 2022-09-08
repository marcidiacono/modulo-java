package com.esolutions.microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esolutions.microservice.models.StandarResponse;
import com.esolutions.microservice.models.User;
import com.esolutions.microservice.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping()
	public StandarResponse getAllUsers() {
		return new StandarResponse(
				HttpStatus.OK.value(),
				"Ok.",
				service.getUsers()
			);
	}
	
	
	@GetMapping("{id}")
	public StandarResponse getUserById(@PathVariable String id) {
		Integer userId = Integer.parseInt(id);
		return new StandarResponse(
				HttpStatus.OK.value(),
				"Ok.",
				service.getUserById(userId)
			);
	}
	
	@PostMapping()
	public StandarResponse create(@RequestBody User user) {
		return new StandarResponse(
					HttpStatus.OK.value(),
					"User created.",
					service.create(user)
				);
	} 
	
}
