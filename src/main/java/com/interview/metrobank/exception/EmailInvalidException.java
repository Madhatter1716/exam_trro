package com.interview.metrobank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class EmailInvalidException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3315717037350008819L;

	public EmailInvalidException() {
		super();
	}

	public EmailInvalidException(String message) {
		super(message);
	}

	public EmailInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailInvalidException(Throwable cause) {
		super(cause);
	}

}
