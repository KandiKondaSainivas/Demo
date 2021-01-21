package com.capg.pbms.exceptions;

public class ChequeBounceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ChequeBounceException(String message) {
		super(message);
	}

	public ChequeBounceException() {
		super();
	}
}
