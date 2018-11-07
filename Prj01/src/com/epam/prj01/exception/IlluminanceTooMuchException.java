package com.epam.prj01.exception;

public class IlluminanceTooMuchException extends Exception {
	private String message;

	public IlluminanceTooMuchException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
