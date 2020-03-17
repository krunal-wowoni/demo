package com.example.demo.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.serviceInterface.StudentInterface;

@Service
public class StudentImpl implements StudentInterface
{
	@Autowired
	StudentRepository studentt;
	
	@Override
	public Student save(Student student)
	{
		Student s = studentt.save(student);
		return s;
	}
	
	@Override
	public Student login(String studId, String password)
	{
		return studentt.findAllByStudIdAndPassword(studId, password);
	}

	@Override
	public List<Student> getAllRegister() 
	{
		return studentt.findAll(); 
	}
}
