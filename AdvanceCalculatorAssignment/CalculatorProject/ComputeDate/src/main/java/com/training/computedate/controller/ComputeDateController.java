package com.training.computedate.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.computedate.dto.Request;
import com.training.computedate.dto.Response;
import com.training.computedate.service.ComputeDateService;

@RestController
public class ComputeDateController {

	@Autowired
	private ComputeDateService computeDateService;
	
	@RequestMapping(value = "/computeDate", method =  RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Response computeDate(@RequestBody Request request) throws ParseException, Exception{
		Response result = computeDateService.computeDate(request);
		return result;
	}
}
