package com.training.utils;

public class RangeCheckException extends Exception {

	private String message;
	
	public RangeCheckException(String string) {

		this.message = string;
	}

	public String getMessage() {
		return this.message;
	}
}
