package com.mb.ecommerce.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value= {UserAlreadyExistException.class})
	@ResponseStatus(HttpStatus.ALREADY_REPORTED)
	public ErrorResponse handleUserAlreadyExistException(Exception e) {
		return new ErrorResponse(new Date(), "User Already Exist",
				e.getMessage(),HttpStatus.ALREADY_REPORTED.value(),
				e.getMessage());
	}
	
	
	@ExceptionHandler(value= {UserNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleUserNotFoundException(Exception e) {
		return new ErrorResponse(new Date(), "User Not Found",
				e.getMessage(),HttpStatus.NOT_FOUND.value(),
				e.getMessage());
	}
	
	@ExceptionHandler(value= {InvalidCredentialsException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleInvalidCredentialsException(Exception e) {
		return new ErrorResponse(new Date(), "Enter Correct Credentials",
				e.getMessage(),HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
	}
	
	

}
