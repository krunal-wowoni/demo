package com.example.demo.serviceInterface;

import com.example.demo.model.User;

public interface UserInterface 
{
	User save(User user);
	
	User login(String userId, String password);
}
