package com.greatlearning.EmployeeManagement.service;

import java.util.List;

import com.greatlearning.EmployeeManagement.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll(String sort);
	
	public Employee findById(int id);
	
	public void save (Employee employee);
	
	public void deleteById(int id);
	
	public List<Employee> searchBy(String firstName);
}
