package com.example.librarymanagement.exception;

/**
 * @author mangvientrieu
 */
public class BusinessException extends RuntimeException {
	private String errorCode;
	private String errorMessage;

	public BusinessException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
