package com.example.rest.dao;

import org.springframework.stereotype.Repository;

import com.example.rest.model.Employee;
import com.example.rest.model.Employees;



@Repository
public class EmployeeDAO 
{
	private static Employees list = new Employees();
	
	static
	{
		list.getEmployeeList().add(new Employee(1, "Krunal", "Redkar", "krunalredkar@gmail.com"));
		list.getEmployeeList().add(new Employee(2, "Sanket", "Jadhav", "sanketjadhav@gmail.com"));
		list.getEmployeeList().add(new Employee(3, "Yashwant", "Shelokar", "yashwantshelokar@gmail.com"));
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