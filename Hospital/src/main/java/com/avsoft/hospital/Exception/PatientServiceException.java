package com.avsoft.hospital.Exception;

public class PatientServiceException extends RuntimeException {

	private String errorMessage;

	public PatientServiceException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return this.errorMessage = errorMessage;
	}
}
