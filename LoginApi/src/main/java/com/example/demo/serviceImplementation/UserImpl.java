package com.example.demo.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceInterface.UserInterface;

@Service
public class UserImpl implements UserInterface
{
	@Autowired
	UserRepository userr;
	
	@Override
	public User save(User user)
	{
		User u = userr.save(user);
		return u;
	}
	
	@Override
	public User login(String userId, String password)
	{
		return userr.findAllByUserIdAndPassword(userId, password);
	}

	@Override
	public List<User> getAllRegister() 
	{
		return userr.findAll();
	}
}
