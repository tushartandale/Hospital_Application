package com.ty.hospital.hospitalappboot.exception;

public class NoIdFoundException extends RuntimeException {

	private String message = "Given Id Is Not Exist";

	public NoIdFoundException(String message) {
		this.message = message;
	}

	public NoIdFoundException() {
	}

	@Override
	public String getMessage() {
		return message;

	}
}