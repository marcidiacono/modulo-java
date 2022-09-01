package com.esolutions.microservice.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esolutions.microservice.exceptions.ElementAlreadyExistsException;
import com.esolutions.microservice.exceptions.ErrorResponse;
import com.esolutions.microservice.models.Country;
import com.esolutions.microservice.services.CountryService;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

	@Autowired
	CountryService service;
	
	@ExceptionHandler(value = ElementAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ErrorResponse handleCountryAlreadyExistsException(ElementAlreadyExistsException ex) {
		return new ErrorResponse(HttpStatus.CONFLICT.value(),
                       ex.getMessage());
	}
	
	@GetMapping()
	public List<Country> getAllCountries() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Country getCountryById(@PathVariable String id) {
		Integer countryId = Integer.parseInt(id);
		return service.findById(countryId);
	}
	
	@PostMapping()
	public Country create(@RequestBody Country country) {
		return service.create(country);
	}
	
	@PutMapping("{id}")
	public Country update(@PathVariable String id, @RequestBody Map<String , String> body) {
		Integer countryId = Integer.parseInt(id);
		String name = body.get("name");
		Country country = new Country();
		country.setName(name);
		return service.update(country, countryId);
	}
	
	@DeleteMapping("{id}")
	public boolean delete(@PathVariable String id) {
		Integer countryId = Integer.parseInt(id);
		return service.deleteById(countryId);
	}
}
