package com.meli.cerebro.exception;

public abstract class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public BaseException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}