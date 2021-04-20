package com.amarispedro.lab.price.infrastructure.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.amarispedro.lab.price.domain.querymodel.exception.MoreThanOnePriceFound;
import com.amarispedro.lab.price.domain.querymodel.exception.PriceNotFound;

@ControllerAdvice
public class PriceExceptionHandler {
	
	 @ExceptionHandler(MoreThanOnePriceFound.class)
	 public ResponseEntity<Object> handleMoreThanOnePriceFound(MoreThanOnePriceFound ex, WebRequest request) {
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "Multiple Prices Found");

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
     }
	
	 @ExceptionHandler(PriceNotFound.class)
	 public ResponseEntity<Object> handlePriceNotFound(PriceNotFound ex, WebRequest request) {
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "Price Not Found");

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
     }
	 
	 
	 @ExceptionHandler(MethodArgumentTypeMismatchException.class)
	 public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "Date Argument Format Error. Correct Format: YYYY-MM-DD-HH.MM.SS");

	        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
     }
	 

}
