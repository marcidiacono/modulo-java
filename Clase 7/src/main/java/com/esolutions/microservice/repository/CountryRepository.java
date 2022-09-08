package com.esolutions.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esolutions.microservice.models.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
	
	Country findByName(String name);

}
