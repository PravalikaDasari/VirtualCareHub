package com.patient.services;

public class PatientNotFoundException extends RuntimeException {
	public PatientNotFoundException(String message, Exception exception) {
		super(message, exception);
		// TODO Auto-generated constructor stub
	}

	public PatientNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
