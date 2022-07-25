package com.mb.ecommerce.exception;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = -1720651664993845669L;
	private String message;
	private String errorCode;
	public String getMessage() {
		return message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public BusinessException(String message,String errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}
	
	public BusinessException() {
		
	}
	
	

}
