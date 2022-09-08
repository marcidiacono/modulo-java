package com.esolutions.microservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esolutions.microservice.exceptions.ElementAlreadyExistsException;
import com.esolutions.microservice.exceptions.NoSuchElementExistsException;
import com.esolutions.microservice.models.Country;
import com.esolutions.microservice.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	CountryRepository repository;

	@Override
	public List<Country> findAll() {
		List<Country> countrys = new ArrayList<Country>();
		repository.findAll().forEach(country -> countrys.add(country));
		return countrys;
	}

	@Override
	public Country findById(Integer id) {
		return repository.findById(id).orElseThrow(
				() -> new NoSuchElementExistsException(
						"No country present with id = " + id));
	}

	@Override
	public Country create(Country country) {
		Country existingCountry = repository.findByName(country.getName());
		if(existingCountry == null) {
			return repository.save(country);
		} else {
			throw new ElementAlreadyExistsException(
	                "Country already exists!!");
		}
	}

	@Override
	public Country update(Country country, Integer id) {
		Country existingCountry = repository.findById(id).orElseThrow(
				() -> new NoSuchElementExistsException(
						"No country present with id = " + id));
		country.setId(existingCountry.getId());
		return repository.save(country);
	}

	@Override
	public boolean deleteById(Integer id) {
		Country existingCountry = repository.findById(id).orElseThrow(
				() -> new NoSuchElementExistsException(
						"No country present with id = " + id));
		repository.deleteById(existingCountry.getId());
		return true;
		
	}

	
}
