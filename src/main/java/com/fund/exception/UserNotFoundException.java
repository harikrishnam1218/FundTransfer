package com.fund.exception;

public class UserNotFoundException extends Exception {
	
	private static final long serialVersionUID = -1635139686449341936L;
	
	private String messgae;

	public String getMessgae() {
		return messgae;
	}  

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	public UserNotFoundException(String messgae) {
		super();
		this.messgae = messgae;
	}

	public UserNotFoundException() {
		super();
	}
	
}
