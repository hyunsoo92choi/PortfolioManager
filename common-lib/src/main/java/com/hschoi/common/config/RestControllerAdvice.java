package com.hschoi.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hschoi.common.exception.EntityAlreadyExistsException;
import com.hschoi.common.exception.EntityNotFoundException;

/**
 * <pre>
 * com.hschoi.common.config_RestControllerAdvice.java
 * </pre>
 * @date : 2019. 6. 19.
 * @author : hychoi
 */
@ControllerAdvice
public class RestControllerAdvice {
	
	private final Logger log = LoggerFactory.getLogger(RestControllerAdvice.class);
	
	@ExceptionHandler(EntityAlreadyExistsException.class)
	public ResponseEntity<Void> entityNotFound(EntityNotFoundException e) {
		log.debug("EntityAlreadyExistsException occur! : {}", e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}
