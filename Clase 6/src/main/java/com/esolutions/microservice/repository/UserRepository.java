package com.esolutions.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esolutions.microservice.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByNameAndLastname(String name, String lastname);
}
