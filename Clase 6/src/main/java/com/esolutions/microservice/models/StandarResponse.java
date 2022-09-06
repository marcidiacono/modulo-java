package com.esolutions.microservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandarResponse {

	private int status;
	private String message;
	private Object data;
	
	public StandarResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}
}
