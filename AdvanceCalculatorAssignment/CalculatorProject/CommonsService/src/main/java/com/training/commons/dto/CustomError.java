package com.training.commons.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomError implements Serializable{

	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	private String description;
}
