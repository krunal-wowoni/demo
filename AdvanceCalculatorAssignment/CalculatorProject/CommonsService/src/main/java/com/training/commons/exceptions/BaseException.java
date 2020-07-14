package com.training.commons.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.training.commons.dto.CustomError;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends Exception{
	
	private static final long serialVersionUID = -815090390728579073L;
	
	private List<CustomError> errors;

	public BaseException() {
		super();
		errors = new ArrayList<>();
	}
	
	public BaseException(List<CustomError> error) {
		super();
		this.errors = errors;
	}
	
	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BaseException(String message) {
		super(message);
	}
	
	public BaseException(Throwable cause) {
		super(cause);
	}
}
