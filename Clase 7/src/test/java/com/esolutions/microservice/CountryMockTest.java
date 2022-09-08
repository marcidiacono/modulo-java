package com.esolutions.microservice;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.esolutions.microservice.controllers.CountryController;
import com.esolutions.microservice.exceptions.NoSuchElementExistsException;
import com.esolutions.microservice.models.Country;
import com.esolutions.microservice.services.CountryService;

@WebMvcTest(CountryController.class)
public class CountryMockTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CountryService service;
	
	@Test
	public void countryShouldReturnList() throws Exception {
		List<Country> countries = new ArrayList<Country>();
		countries.add(new Country(1, "Argentina"));
		
		when(service.findAll()).thenReturn(countries);
		this.mockMvc.perform(get("/api/countries")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json("{\r\n" + 
						"    \"status\": 200,\r\n" + 
						"    \"message\": \"Ok.\",\r\n" + 
						"    \"data\": [\r\n" + 
						"        {\r\n" + 
						"            \"id\": 1,\r\n" + 
						"            \"name\": \"Argentina\"\r\n" + 
						"        }\r\n" + 
						"    ]\r\n" + 
						"}"));
	}
	
	@Test
	public void countryShouldReturnOneCountry() throws Exception {
		Country country = new Country(1, "Argentina");
		
		when(service.findById(1)).thenReturn(country);
		this.mockMvc.perform(get("/api/countries/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json("{\"id\" : 1, \"name\" : \"Argentina\"}"));
	}
	
	@Test
	public void countryShouldReturnError() throws Exception {
		
		when(service.findById(4)).thenThrow(new NoSuchElementExistsException("No country present with id = 4"));
		this.mockMvc.perform(get("/api/countries/4")).andDo(print()).andExpect(status().is(404))
				.andExpect(content().json("{\r\n" + 
						"    \"status\": 404,\r\n" + 
						"    \"message\": \"No country present with id = 4\",\r\n" + 
						"    \"data\": null\r\n" + 
						"}"));
	}
	
	@Test
	public void countryShouldDelete() throws Exception {
		
		when(service.deleteById(1)).thenReturn(true);
		this.mockMvc.perform(delete("/api/countries/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("true"));
	}

}
