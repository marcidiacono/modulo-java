package com.esolutions.microservice.exceptions;

public class NoSuchElementExistsException extends RuntimeException {
 
   	private static final long serialVersionUID = 1L;
 
    public NoSuchElementExistsException() {
    	
    }
 
    public NoSuchElementExistsException(String message) {
        super(message);
    }
}
