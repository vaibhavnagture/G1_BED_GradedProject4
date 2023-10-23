package com.greatlearning.EmployeeManagement.service;

import java.util.List;

import com.greatlearning.EmployeeManagement.entity.Role;

public interface RoleService {

	public List<Role> findAll();
	
	public Role findById(int id);
	
	public void save (Role role);
}
