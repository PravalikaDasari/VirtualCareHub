package com.virtualcare.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@ControllerAdvice
public class BranchExceptionHandler {

	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<String> exception(IdNotFoundException exception) {
		log.error("NoSuchElementException-" + exception.getMessage(), exception);
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
