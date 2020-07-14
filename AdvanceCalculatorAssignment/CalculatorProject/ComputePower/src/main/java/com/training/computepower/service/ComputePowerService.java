package com.training.computepower.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.computepower.dto.Request;
import com.training.computepower.dto.Response;

@Service
public class ComputePowerService {

	public Response calculatePower(@RequestBody Request request) throws Exception {
		
		String service = "compute_power";
		if(!service.equals(request.getService()))
			throw new Exception("Invalid Service Name");
		
		double number1 = Double.parseDouble(request.getParam1());
		double number2 = Double.parseDouble(request.getParam2());
		
		double result = Math.pow(number1, number2);
		
		Response resp = new Response();
		resp.setResult(new Double(result).longValue());
		
		return resp;
	}
}
