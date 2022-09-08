package com.esolutions.microservice.services;

import java.util.List;

import com.esolutions.microservice.models.User;

public interface UserService {
	
	public List<User> getUsers();
	public User getUserById(int id);
	public User create(User user);

}
