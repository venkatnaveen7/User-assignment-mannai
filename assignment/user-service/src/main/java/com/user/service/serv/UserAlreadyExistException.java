package com.user.service.serv;

public class UserAlreadyExistException extends RuntimeException {

	public UserAlreadyExistException() {
	}

	public UserAlreadyExistException(String s) {
		super(s);
	}
}
