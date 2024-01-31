package com.virtualcare.exceptions;

public class IDNotValid extends Exception {

	private static final long serialVersionUID = 1L;
	
	public IDNotValid (String message) {
		super(message);
	}
	
	public IDNotValid(String message,Throwable throwable) {
		super(message,throwable);
	}

}
