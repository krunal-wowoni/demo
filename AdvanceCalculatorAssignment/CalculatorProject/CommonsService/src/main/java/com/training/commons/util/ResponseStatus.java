package com.training.commons.util;

import static com.training.commons.util.ResponseStatusEnum.Success;

public interface ResponseStatus {

	String getResponseCode();
	
	String getResponseDescription();
	

	default boolean isSuccess() {
		return isSuccess(getResponseCode());
	}
	
	default boolean isNotSuccess() {
		return !isSuccess();
	}
	
	public static boolean isSuccess(String responseCode) {
		return Success.getResponseCode().equals(responseCode);
	}
	
	public static boolean isNotSuccess(String responseCode) {
		return !isSuccess(responseCode);
	}
}
