package com.training.computepower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.computepower.dto.Request;
import com.training.computepower.dto.Response;
import com.training.computepower.service.ComputePowerService;

@RestController
public class ComputePowerController {

	@Autowired
	private ComputePowerService computePowerService;
	
	@RequestMapping(value = "/computePower", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Response computePower(@RequestBody Request request) throws Exception{
		
		Response result = computePowerService.calculatePower(request);
		return result;
	}
}
