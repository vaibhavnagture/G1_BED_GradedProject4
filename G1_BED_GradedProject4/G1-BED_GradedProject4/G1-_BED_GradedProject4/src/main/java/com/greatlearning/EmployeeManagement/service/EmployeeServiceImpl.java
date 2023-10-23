package com.greatlearning.EmployeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.entity.Employee;
import com.greatlearning.EmployeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll(String sort) {
		if(sort.isEmpty()) {
			return employeeRepository.findAll();
		}
		Direction direction = sort.equals("asc") ? Direction.ASC : Direction.DESC;
		return employeeRepository.findAll(Sort.by(direction, "firstName"));
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> searchBy(String firstName) {
		return employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
	}

}
