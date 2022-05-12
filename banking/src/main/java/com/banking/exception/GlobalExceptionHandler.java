package com.banking.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details=new ArrayList<>();
		for(ObjectError error:ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ErrorMessage error=new ErrorMessage(300L,details);
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		

}
	
	@ExceptionHandler(AccountInfoNotFoundException.class)
	public ResponseEntity<Object> handleCustomerNotFound(AccountInfoNotFoundException ex,WebRequest req){
		List<String> details=new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorMessage error=new ErrorMessage(500L,details);
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
}
