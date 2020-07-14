package com.training.commons.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Response implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long result;
}
