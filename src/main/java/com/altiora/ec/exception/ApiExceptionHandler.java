package com.altiora.ec.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomErrorResponse.class)
	public ResponseEntity<CustomErrorResponse> handleAllException(Exception ex, WebRequest request) {
		CustomErrorResponse err = new CustomErrorResponse(ex.getMessage());
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	@ExceptionHandler(CustomErrorResponse.class)
//	public ResponseEntity<Object> handleEmailAlreadyRegistered(CustomErrorResponse ex) {
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("message", ex.getMessage()));
//	}

}
