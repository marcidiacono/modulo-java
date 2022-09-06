package com.esolutions.microservice.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esolutions.microservice.exceptions.ElementAlreadyExistsException;
import com.esolutions.microservice.exceptions.NoSuchElementExistsException;
import com.esolutions.microservice.models.User;
import com.esolutions.microservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	Validator validator;
	
	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}
	
	@Override
	public User getUserById(int id) {
		return repository.findById(id).orElseThrow(
				() -> new NoSuchElementExistsException(
						"No user present with id = " + id));
	}
	
	@Override
	public User create(User user) {
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		if(!violations.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for(ConstraintViolation<User> constraintViolation : violations) {
				sb.append(constraintViolation.getPropertyPath() + ": " + constraintViolation.getMessage());
			}
			throw new ConstraintViolationException("Error: " + sb.toString(), violations);
		}
		User existingUser = repository.findByNameAndLastname(user.getName(), user.getLastname());
		if(existingUser == null) {
			return repository.save(user);
		} else {
			throw new ElementAlreadyExistsException(
	                "User already exists.");
		}
		
	}

	

	
	
	

}
