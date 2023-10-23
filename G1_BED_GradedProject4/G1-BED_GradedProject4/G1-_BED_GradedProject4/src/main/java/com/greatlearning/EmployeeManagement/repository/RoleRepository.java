package com.greatlearning.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.EmployeeManagement.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
