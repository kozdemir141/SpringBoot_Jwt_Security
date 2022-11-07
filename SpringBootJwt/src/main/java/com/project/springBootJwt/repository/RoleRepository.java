package com.project.springBootJwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springBootJwt.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByName(String name);
}
