package com.app.custom_exception;

@SuppressWarnings("serial")
public class AuthenticationFailureException extends RuntimeException {
	public AuthenticationFailureException(String mesg) {
		super(mesg);
	}
}
