package com.interview.metrobank.exception;

public class EnumNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8714088833335444777L;
	
	public EnumNotFoundException() {
		super();
	}

	public EnumNotFoundException(String message) {
		super(message);
	}
	
	

	public EnumNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EnumNotFoundException(Throwable cause) {
		super(cause);
	}

}
