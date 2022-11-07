package com.project.springBootJwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springBootJwt.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
