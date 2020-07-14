package com.training.commons.exceptions;

import java.util.List;

import com.training.commons.dto.CustomError;

public class InvalidInputException extends BaseException{
	
	private static final long serialVersionUID = 7589908458616220606L;
	
	public InvalidInputException() {
		super();
	}
	
	public InvalidInputException(List<CustomError> error) {
		super(error);
	}

	public InvalidInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidInputException(String message) {
		super(message);
	}
	
	public InvalidInputException(Throwable cause) {
		super(cause);
	}
}
