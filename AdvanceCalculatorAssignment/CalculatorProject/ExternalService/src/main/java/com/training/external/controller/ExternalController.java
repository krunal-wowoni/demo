package com.training.external.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.commons.config.JwtTokenUtil;
import com.training.commons.dto.JwtRequest;
import com.training.commons.dto.JwtResponse;
import com.training.commons.dto.Request;
import com.training.commons.dto.Response;
import com.training.commons.exceptions.InvalidInputException;
import com.training.commons.service.JwtUserDetailsService;

@CrossOrigin
@RestController
public class ExternalController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<?> authenticationToken(@Valid @RequestBody JwtRequest jwtRequest) throws Exception{
		
		authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		
		final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	private void authenticate(String username, String password)throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch(BadCredentialsException e) {
			throw new InvalidInputException("Invalid Credentials");
		}
	}
	
	@RequestMapping(value = "/doPower", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Response doPower(@Valid @RequestBody Request request)throws Exception {	
	
		final String url = "http://localhost:8082/computePower";
				
		RestTemplate rs = new RestTemplate();
		
		Response resp = rs.postForObject(url, request, Response.class);
		if(resp != null)
		resp.toString();
		
		return resp;
	}
	
	@RequestMapping(value = "/doDate", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Response doDate(@Valid @RequestBody Request request) {
	
		final String url = "http://localhost:8081/computeDate";
				
		RestTemplate rs = new RestTemplate();
		
		Response resp = rs.postForObject(url, request, Response.class);
		
		if(resp != null)
		resp.getResult();
		
		return resp;
	}
}
