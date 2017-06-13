package com.synowiec.dao.interfaces;

import com.synowiec.domain.Employee;

import java.util.List;

public interface EmployeeDao {
	Employee findEmployee(long id);
	List<Employee> getAllEmployees();
	void addEmployee(Employee employee); 
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
}
