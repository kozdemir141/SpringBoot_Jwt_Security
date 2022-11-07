package com.project.springBootJwt.service;

import java.util.List;

import com.project.springBootJwt.domain.Role;
import com.project.springBootJwt.domain.User;

public interface UserService {

	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String roleName);

	User getUser(String username);

	//in the real world Application we probably would't hit that because this is try to load everything in database
	//in the real world we would usually return a page to a user(Pagination)
	List<User> getUsers();
}
