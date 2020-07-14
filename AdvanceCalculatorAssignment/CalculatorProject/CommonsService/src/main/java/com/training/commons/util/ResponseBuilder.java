package com.training.commons.util;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.training.commons.dto.CustomError;
import com.training.commons.dto.CustomResponse;

@Component
public class ResponseBuilder<T> {

	public ResponseBuilder() {
	
	}

	public CustomResponse<T> buildResponse(CustomResponse<T> customResponse){
		
		CustomResponse<T> response = customResponse;
		response.setErrors(Collections.emptyList())
				.setTimeStamp(LocalDateTime.now().toString());
		return response;
	}
	
	
	public CustomResponse<T> buildResponse(List<?> payload, List<CustomError> errors){
		
		CustomResponse<T> response = new CustomResponse<>();
		response.setErrors(errors)
				.setPayload(payload)
				.setTimeStamp(LocalDateTime.now().toString());
		
		return response;
	}
	
	public CustomResponse<T> buildResponse(List<?> payload, List<CustomError> errors, String correlationId){
		
		CustomResponse<T> response = new CustomResponse<>();
		response.setCorrelationId(correlationId)
				.setErrors(errors)
				.setPayload(payload)
				.setTimeStamp(LocalDateTime.now().toString());
		
		return response;
	}
}
