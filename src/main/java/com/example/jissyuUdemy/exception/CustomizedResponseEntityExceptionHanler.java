package com.example.jissyuUdemy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHanler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
//		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
//				request.getDescription(false));
//
//		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//
//	@ExceptionHandler(CustomerNotFoundException.class)
//	public final ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
//		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
//				request.getDescription(false));
//
//		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
//	}
//
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Failed",
//				ex.getBindingResult().toString());
//		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
//	}

}
