package com.epam.prj01.exception;

public class SpaceUsageTooMuchException extends Exception {
	private String message;

	public SpaceUsageTooMuchException(String message) {
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
