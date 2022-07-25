package com.mb.ecommerce.exception;

public class EmptyInputException extends RuntimeException{

	private static final long serialVersionUID = 6163830854256421884L;
	
	public EmptyInputException(String message) {
		super(message);
	}
	

}
