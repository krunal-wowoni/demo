package com.training.commons.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String service;
	private String param1;
	private String param2;
}
