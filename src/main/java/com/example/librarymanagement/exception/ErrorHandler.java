package com.example.librarymanagement.exception;


import com.example.librarymanagement.dto.api.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author mangvientrieu
 */
@Slf4j
@ControllerAdvice
public class ErrorHandler {

	// Customize exception
	@ExceptionHandler
	public ResponseEntity<ResponseDto<?>> handleBusinessException(BusinessException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseDto.fail(null, exception));
	}

	@ExceptionHandler
	public ResponseEntity<ResponseDto<?>> handleUnknownException(Exception exception) {
		log.error("Error", exception);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseDto.fail(null, exception));
	}
}

