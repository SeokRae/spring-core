package com.example.logtrace.global;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<Object> exception(IllegalStateException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
