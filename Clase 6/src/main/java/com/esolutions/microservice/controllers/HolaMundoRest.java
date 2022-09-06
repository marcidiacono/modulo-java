package com.esolutions.microservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoRest {
	
	@GetMapping("/holamundo")
	public String greeting() {
		return "Hello World";
	}

}
