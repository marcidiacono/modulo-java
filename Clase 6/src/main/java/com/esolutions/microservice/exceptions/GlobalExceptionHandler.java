package com.esolutions.microservice.exceptions;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.esolutions.microservice.models.StandarResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public @ResponseBody StandarResponse handleConstraintViolationException(ConstraintViolationException err) {
		Map<String, String> errors = new HashMap<String, String>();
		for(ConstraintViolation<?> constraintViolation : err.getConstraintViolations()) {
			errors.put(constraintViolation.getPropertyPath().toString()
					, constraintViolation.getMessage());
		}
		return new StandarResponse(
				HttpStatus.BAD_REQUEST.value(),
				"Validation error.",
				errors
			);
	}
	
	
	@ExceptionHandler(value = ElementAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public @ResponseBody StandarResponse handleCountryAlreadyExistsException(ElementAlreadyExistsException err) {
		return new StandarResponse(
				HttpStatus.CONFLICT.value(),
				err.getMessage()
			);
	}
	
	
	@ExceptionHandler(value = NoSuchElementExistsException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public @ResponseBody StandarResponse handleCountryNoSuchElementExistsException(NoSuchElementExistsException err) {
		return new StandarResponse(
				HttpStatus.NOT_FOUND.value(),
				err.getMessage()
			);
	}

}
