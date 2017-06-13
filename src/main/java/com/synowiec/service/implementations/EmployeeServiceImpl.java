package com.synowiec.service.implementations;

import com.synowiec.dao.interfaces.EmployeeDao;
import com.synowiec.dao.interfaces.EmployeeTypeDao;
import com.synowiec.domain.Employee;
import com.synowiec.domain.EmployeeType;
import com.synowiec.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService{

 	@Autowired
    EmployeeDao employeeDao;
	@Autowired
    EmployeeTypeDao employeeTypeDao;

	@Override
	@Transactional
	public Employee findEmployeeById(long id) {
		return employeeDao.findEmployee(id);
	};

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	};

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	};

	@Override
	@Transactional
	public void updateEmployee(Employee employee){
		employeeDao.updateEmployee(employee);
	};

	@Override
	@Transactional
	public void deleteEmployee(Employee employee){
		employeeDao.deleteEmployee(employee);
	};

	@Override
	@Transactional
	public EmployeeType findEmployeeTypeById(long id) {
		return employeeTypeDao.findEmployeeType(id);
	}

	@Override
	@Transactional
	public List<EmployeeType> getAllEmployeeTypes() {
		return employeeTypeDao.getAllEmployeeTypes();
	}

	@Override
	@Transactional
	public void addEmployeeType(EmployeeType empType) {
		employeeTypeDao.addEmployeeType(empType);
	}

	@Override
	@Transactional
	public void updateEmployeeType(EmployeeType empType) {
		employeeTypeDao.updateEmployeeType(empType);
	}

	@Override
	@Transactional
	public void deleteEmployeeType(EmployeeType empType) {
		employeeTypeDao.deleteEmployeeType(empType);
	}
	
}
