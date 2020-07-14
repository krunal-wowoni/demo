package com.training.commons.util;

import java.util.Optional;

import lombok.Getter;

public enum ResponseStatusEnum implements ResponseStatus {

	Success("00", "Success"),
	FormatError("30", "Format Error"),
	InvalidInput("01", "Invalid Input");
	
	
	public static Optional<ResponseStatus> findByCode(String code){
		if(code!=null) {
			for(ResponseStatusEnum rs: values()) {
				if(rs.getResponseCode().equals(code)) {
					return Optional.of(rs);
				}
			}
		}
		return Optional.empty();
	}
	
	private ResponseStatusEnum(String responseCode, String responseDescription) {
		this.responseCode = responseCode;
		this.responseDescription = responseDescription;
	}

	@Getter
	private final String responseCode, responseDescription;
	
	@Override
	public String toString() {
		return responseCode;
	}
}
