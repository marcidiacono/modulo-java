package com.esolutions.microservice.exceptions;

public class ElementAlreadyExistsException extends RuntimeException {
 
   	private static final long serialVersionUID = 1L;
 
    public ElementAlreadyExistsException() {
    	
    }
 
    public ElementAlreadyExistsException(String message) {
        super(message);
    }
}
