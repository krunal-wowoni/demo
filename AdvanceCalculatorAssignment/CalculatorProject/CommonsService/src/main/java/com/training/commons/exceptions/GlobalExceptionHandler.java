package com.training.commons.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.training.commons.util.ResponseStatusEnum.FormatError;
import static com.training.commons.util.ResponseStatusEnum.InvalidInput;
import com.training.commons.dto.CustomError;
import com.training.commons.util.ResponseBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private ResponseBuilder<?> responseBuilder;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		log.info("handleMethodArgumentNotValid--", ex.getMessage() );
		log.error("error track", ex);
		
		List<CustomError> errors = new ArrayList<>();
		for(FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(new CustomError(FormatError.getResponseCode(), 
					error.getField() + ": "+error.getDefaultMessage() +": "+
			error.getRejectedValue(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBuilder.buildResponse(Collections.emptyList(), errors));
	}
	
	@ExceptionHandler({InvalidInputException.class})
	public ResponseEntity<?> handleInvalidInputException(HttpServletRequest httpServletRequest, InvalidInputException ex){
		log.info("handleInvalidInputException --", ex.getMessage());
		log.error("error track -", ex);
		
		CustomError error = new CustomError();
		error.setCode(InvalidInput.getResponseCode());
		error.setMessage(InvalidInput.getResponseDescription());
		error.setDescription(HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
								.body(responseBuilder.buildResponse(Collections.emptyList(), Arrays.asList(error)));
	}
	
}
