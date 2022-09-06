package com.esolutions.microservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Name must not be blank")
	private String name;
	
	@NotBlank(message = "Lastname must not be blank")
	private String lastname;
	
	@NotNull(message = "Password must be between 4 to 8 characters")
	@Size(min = 4, max = 8, message = "Password must be between 4 to 8 characters")
	private String password;
	
	@Min(value = 18, message = "Age should not be less than 18")
	private int age;
	
}
