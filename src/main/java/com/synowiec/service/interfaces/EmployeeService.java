package com.synowiec.service.interfaces;

import com.synowiec.domain.Employee;
import com.synowiec.domain.EmployeeType;

import java.util.List;

;

public interface EmployeeService {
	
	Employee findEmployeeById(long id);
	List<Employee> getAllEmployees();
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	
	EmployeeType findEmployeeTypeById(long id); 
	List<EmployeeType> getAllEmployeeTypes();
	void addEmployeeType(EmployeeType empType); 
	void updateEmployeeType(EmployeeType empType);
	void deleteEmployeeType(EmployeeType empType);

}
