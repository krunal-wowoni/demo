package com.example.demo.serviceInterface;

import java.util.List;

import com.example.demo.model.User;

public interface UserInterface 
{
	User save(User user);
	
	User login(String userId, String password);

	List<User> getAllRegister();
}
