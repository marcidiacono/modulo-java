package com.esolutions.microservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private Integer statusCode;
	private String message;
	
	public ErrorResponse(String message) {
		super();
		this.message = message;
	}
}
