package com.greatlearning.EmployeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.entity.Role;
import com.greatlearning.EmployeeManagement.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(int id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}
}
