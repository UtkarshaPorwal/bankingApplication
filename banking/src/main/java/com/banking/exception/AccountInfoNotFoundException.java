package com.banking.exception;

public class AccountInfoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AccountInfoNotFoundException(){
		super();
		}
	public AccountInfoNotFoundException(String message){
		super(message);
	}

}
