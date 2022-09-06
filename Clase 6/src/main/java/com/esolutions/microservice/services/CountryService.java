package com.esolutions.microservice.services;

import java.util.List;

import com.esolutions.microservice.models.Country;

public interface CountryService {
	
	public List<Country> findAll();
	public Country findById(Integer id);
	public Country create(Country country);
	public Country update(Country country, Integer id);
	public boolean deleteById(Integer id);

}
