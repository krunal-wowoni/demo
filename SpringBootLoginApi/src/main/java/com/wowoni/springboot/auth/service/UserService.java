package com.wowoni.springboot.auth.service;

import com.wowoni.springboot.auth.model.User;

public interface UserService 
{
	void save(User user);
	
	User findByUsername(String username);
}
