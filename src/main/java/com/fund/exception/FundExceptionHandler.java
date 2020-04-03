package com.fund.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FundExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception) {
		ErrorResponse er = new ErrorResponse();
		er.setCode("USER-400");
		er.setMessage(exception.getMessgae());
		return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DBException.class)
	public ResponseEntity<ErrorResponse> handleDBException(DBException exception) {
		ErrorResponse er = new ErrorResponse();
		er.setCode("DB-500");
		er.setMessage(exception.getMessgae());
		return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FundException.class)
	public ResponseEntity<ErrorResponse> handleFundException(FundException exception) {
		ErrorResponse er = new ErrorResponse();
		er.setCode("TRANSFER-500");
		er.setMessage(exception.getMessage());
		return new ResponseEntity(er, HttpStatus.BAD_REQUEST);
	}
}