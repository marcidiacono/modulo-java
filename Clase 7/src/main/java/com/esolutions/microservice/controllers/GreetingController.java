package com.esolutions.microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esolutions.microservice.services.GreetingService;

@RestController
public class GreetingController {

	@Autowired
	GreetingService service;
	

	@GetMapping("/greeting")
	public String greeting() {
		return service.greet();
	}

}