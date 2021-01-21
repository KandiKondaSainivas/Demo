package com.capg.pbms.exceptions;


public class InsufficientBalanceException  extends Exception{
	private static final long serialVersionUID = 1L;
	
	public InsufficientBalanceException() {
		super();
	}
	public InsufficientBalanceException(String message) {
		super(message);
	}
	
}
