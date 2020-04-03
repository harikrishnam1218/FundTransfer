package com.fund.exception;

public class FundException extends Exception{

	private String message;
	
	private Exception exp;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getExp() {
		return exp;
	}

	public void setExp(Exception exp) {
		this.exp = exp;
	}

	public FundException(String message, Exception exp) {
		super();
		this.message = message;
		this.exp = exp;
	}

	public FundException(String message) {
		super();
		this.message = message;
	}

	public FundException() {
		super();
	}
	
}
