package br.com.controle.acesso.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralHandleException {
  	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e , HttpServletRequest request ){
	  StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis() );	
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);	
	}	
  
	@ExceptionHandler(DataSaveException.class)
	public ResponseEntity<StandardError> dataSave(DataSaveException e , HttpServletRequest request ){
	  StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis() );	
	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);	
	}	
	  
  	
}
