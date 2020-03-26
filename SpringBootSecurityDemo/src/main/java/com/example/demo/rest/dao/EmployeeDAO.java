package com.example.demo.rest.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.rest.model.Employee;
import com.example.demo.rest.model.Employees;

@Repository
public class EmployeeDAO 
{
	private static Employees list = new Employees();
	
	static
	{
		list.getEmployeeList().add(new Employee(1, "Krunal", "Redkar", "krunalredkar@gmail.com"));
		list.getEmployeeList().add(new Employee(2, "Sanket", "Jadhav", "sanketjadhav@gmail.com"));
		list.getEmployeeList().add(new Employee(3, "Vibhav", "Takey", "vibhavtakey@gmail.com"));
		list.getEmployeeList().add(new Employee(4, "Yashwant", "Shelokar", "yashwantshelokar@gmail.com"));
	}
	
	public Employees getAllEmployees()
	{
		return list;
	}
	
	public void addEmployee(Employee employee)
	{
		list.getEmployeeList().add(employee);
	}
}
