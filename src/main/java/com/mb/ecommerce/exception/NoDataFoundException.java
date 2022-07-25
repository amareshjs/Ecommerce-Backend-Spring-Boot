package com.mb.ecommerce.exception;

import org.springframework.stereotype.Component;

@Component
public class NoDataFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 2931334207262034985L;
	private String errorCode;
	private String errorMsg;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public NoDataFoundException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	public NoDataFoundException() {
		
	}
	
	

}
