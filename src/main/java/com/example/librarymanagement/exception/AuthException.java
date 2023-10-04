package com.example.librarymanagement.exception;

import lombok.Getter;

/**
 * @author mangvientrieu
 */
@Getter
public class AuthException extends RuntimeException {
	private final String errorCode;
	private final String errorMessage;

	public AuthException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
