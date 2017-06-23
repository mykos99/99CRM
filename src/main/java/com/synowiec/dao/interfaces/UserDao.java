package com.synowiec.dao.interfaces;

import com.synowiec.domain.User;

import java.util.List;

public interface EmployeeDao {
	User findEmployee(long id);
	List<User> getAllEmployees();
	void addEmployee(User user);
	void updateEmployee(User user);
	void deleteEmployee(User user);
}
