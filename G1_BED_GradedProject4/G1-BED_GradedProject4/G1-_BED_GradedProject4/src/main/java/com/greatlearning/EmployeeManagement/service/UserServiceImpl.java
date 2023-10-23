package com.greatlearning.EmployeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagement.entity.User;
import com.greatlearning.EmployeeManagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}
}
