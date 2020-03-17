package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.serviceInterface.StudentInterface;
import com.google.gson.Gson;

@RestController
public class StudentController 
{
	@Autowired
	StudentInterface studInterface;
	
	@RequestMapping("/hi")
	public String index()
	{
		return "Welcome Students";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
	public String register(@RequestBody Student student)
	{
		Student st = studInterface.save(student);
		
		if(st == null)
		{
			return "Registration Failed.. Try again..";
		}
		else
		{
			return st.getFirstName()+" "+st.getLastName()+" Your Registration is Successful..";
		}		
	}
	
	@RequestMapping(value = "/login")
	public String login(@RequestBody Student stud)
	{
		Student st = studInterface.login(stud.getStudId(), stud.getPassword());
		
		if(st == null)
		{
			return "Invalid studId and password.";
		}
		else
		{
			return "Welcome "+st.getFirstName()+" "+st.getLastName();
		}
	}
	
	@RequestMapping("/allstudent")
	public List getAllStudent()
	{
		List<Student> allstudent = studInterface.getAllRegister();
		return allstudent;
	}
}
