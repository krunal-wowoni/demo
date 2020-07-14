package com.training.commons.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.ToString;

@ToString
public class CustomResponse<T extends Object> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<?> payload;
	private List<CustomError> errors;
	private boolean isSuccess;
	private String correlationId;
	private String timeStamp;
	
	public CustomResponse() {
		payload = new ArrayList<>();
		errors = new ArrayList<>();
	}

	public CustomResponse(List<?> payload, List<CustomError> errors, boolean isSuccess, String correlationId,
			String timeStamp) {
		super();
		this.payload = payload;
		this.errors = errors;
		this.isSuccess = isSuccess;
		this.correlationId = correlationId;
		this.timeStamp = timeStamp;
	}
	
	public List<?> getPayload(){
		return payload;
	}
	
	public CustomResponse<T> setPayload(List<?> payload){
		if(payload.isEmpty()) {
			this.payload = Collections.emptyList();
		}else {
			this.payload = payload;
			this.isSuccess = true;
		}
		return this;
	}
	
	public List<CustomError> getErrors(){
		return errors;
	}
	
	public CustomResponse<T> setErrors(List<CustomError> errors){
		if(errors.isEmpty()) {
			this.errors = Collections.emptyList();
		}else {
			this.errors = errors;
			this.isSuccess = false;
		}
		return this;
	}
	
	public boolean isSuccess() {
		return isSuccess();
	}
	
	public CustomResponse<T> setSuccess(boolean isSuccess){
		this.isSuccess = isSuccess;
		return this;
	}
	
	public String getCorrelationId() {
		return correlationId;
	}
	
	public CustomResponse<T> setCorrelationId(String correlationId){
		this.correlationId = correlationId;
		return this;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}
	
	public CustomResponse<T> setTimeStamp(String timeStamp){
		this.timeStamp = timeStamp;
		return this;
	}
}
