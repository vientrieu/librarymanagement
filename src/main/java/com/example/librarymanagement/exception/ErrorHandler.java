package com.example.librarymanagement.exception;


import com.example.librarymanagement.dto.api.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author mangvientrieu
 */
@ControllerAdvice
public class ErrorHandler {

	// Customize exception
	@ExceptionHandler
	public ResponseEntity<ResponseDto<?>> handleBusinessException(BusinessException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.fail(null, exception));
	}

	@ExceptionHandler
	public ResponseEntity<ResponseDto<?>> handleUnknownException(Exception exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseDto.fail(null, exception));
	}
}

