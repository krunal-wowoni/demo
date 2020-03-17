package com.example.demo.serviceInterface;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentInterface 
{
	Student save(Student student);
	
	Student login(String userId, String password);

	List<Student> getAllRegister();
}
