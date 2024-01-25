package com.patient.services;

public class PatientNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PatientNotFoundException(String message, Exception exception) {
		super(message, exception);
	}

	public PatientNotFoundException(String message) {
		super(message);
	}
}
