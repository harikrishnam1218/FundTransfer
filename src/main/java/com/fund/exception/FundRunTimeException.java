package com.fund.exception;

public class FundRunTimeException extends RuntimeException{
	
	private String message;
	private Exception ex;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Exception getEx() {
		return ex;
	}
	public void setEx(Exception ex) {
		this.ex = ex;
	}
	public FundRunTimeException(String message, Exception ex) {
		super();
		this.message = message;
		this.ex = ex;
	}
	public FundRunTimeException(String message) {
		super();
		this.message = message;
	}
	public FundRunTimeException() {
		super();
	}
	
	
}
