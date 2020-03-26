package com.wowoni.springboot.auth.service;

public interface SecurityService 
{
	String findLoggedInUsername();
	
	void autoLogin(String username, String password);
}
