package com.na.handler;

public class InvalidParameterException extends RuntimeException {

	private static final long serialVersionUID = 1405894L;

	public InvalidParameterException(String msg) {
		super(msg);
	}
}
