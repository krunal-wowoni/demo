package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.serviceInterface.UserInterface;


@RestController
public class UserController 
{
	@Autowired
	UserInterface ui;
	
	@RequestMapping("/hi")
	public String index()
	{
		return "Welcome..";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
	public String register(@RequestBody User user)
	{
		User u = ui.save(user);
		System.out.println(user.getMailId());
		
		if(u == null)
		{
			return "Registration Failed.. Try Again..";
		}
		else
		{
			return "Registration Successful..";
		}
	}
	
	
	@RequestMapping("/login")
	public String login(@RequestBody User us)
	{		
		User u = ui.login(us.getUserId(), us.getPassword());
		
		if(u == null)
		{
			return "Invalid userId or password.";
		}
		else
		{
			return "Welcome "+ u.getUserId();
		}
	}
	
	@RequestMapping("/getallregister")
	public List allRegister()
	{
		List<User> allusers = ui.getAllRegister();
		
		return allusers;
		
	}
}
