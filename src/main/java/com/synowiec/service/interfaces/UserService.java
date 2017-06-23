package com.synowiec.service.interfaces;

import com.synowiec.domain.User;
import com.synowiec.domain.UserRole;

import java.util.List;

;

public interface UserService {
	
	User findUserById(long id);
	List<User> getAllUsers();
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	
	UserRole findUserRoleById(long id);
	List<UserRole> getAllUserRoles();
	void addUserRole(UserRole userRole);
	void updateUserRole(UserRole userRole);
	void deleteUserRole(UserRole userRole);

}
