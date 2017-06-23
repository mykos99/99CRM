package com.synowiec.service.interfaces;

import com.synowiec.domain.Employee;
import com.synowiec.domain.UserRole;

import java.util.List;

;

public interface EmployeeService {
	
	Employee findEmployeeById(long id);
	List<Employee> getAllEmployees();
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	
	UserRole findEmployeeTypeById(long id);
	List<UserRole> getAllEmployeeTypes();
	void addEmployeeType(UserRole empType);
	void updateEmployeeType(UserRole empType);
	void deleteEmployeeType(UserRole empType);

}
