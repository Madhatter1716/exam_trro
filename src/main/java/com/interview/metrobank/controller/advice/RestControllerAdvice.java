package com.interview.metrobank.controller.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.interview.metrobank.exception.EntityNotFoundException;
import com.interview.metrobank.responseDTO.StatusResponseDTO;


@Order(Ordered.HIGHEST_PRECEDENCE)
@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
		List<String> errors = ex.getBindingResult().getFieldErrors()
              .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
		
		return ResponseEntity.status(400).body(new StatusResponseDTO(400, errors.toString()));
	}
	
	@ExceptionHandler(value = { EntityNotFoundException.class })
	protected ResponseEntity<Object> handleRecipeException(Exception ex, WebRequest request) {
		
		return ResponseEntity.status(401).body(new StatusResponseDTO(401, ex.getMessage()));
	}


}