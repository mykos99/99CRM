package com.synowiec.service.implementations;

import com.synowiec.dao.interfaces.UserDao;
import com.synowiec.dao.interfaces.UserRoleDao;
import com.synowiec.domain.User;
import com.synowiec.domain.UserRole;
import com.synowiec.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService{

 	@Autowired
	UserDao userDao;
	@Autowired
	UserRoleDao userRoleDao;

	@Override
	@Transactional
	public User findEmployeeById(long id) {
		return userDao.findUser(id);
	};

	@Override
	@Transactional
	public List<User> getAllEmployees() {
		return userDao.getAllUsers();
	};

	@Override
	@Transactional
	public void addEmployee(User user) {
		userDao.addUser(user);
	};

	@Override
	@Transactional
	public void updateEmployee(User user){
		userDao.updateUser(user);
	};

	@Override
	@Transactional
	public void deleteEmployee(User user){
		userDao.deleteUser(user);
	};

	@Override
	@Transactional
	public UserRole findEmployeeTypeById(long id) {
		return userRoleDao.findEmployeeType(id);
	}

	@Override
	@Transactional
	public List<UserRole> getAllEmployeeTypes() {
		return userRoleDao.getAllEmployeeTypes();
	}

	@Override
	@Transactional
	public void addEmployeeType(UserRole empType) {
		userRoleDao.addEmployeeType(empType);
	}

	@Override
	@Transactional
	public void updateEmployeeType(UserRole empType) {
		userRoleDao.updateUserRole(empType);
	}

	@Override
	@Transactional
	public void deleteEmployeeType(UserRole empType) {
		userRoleDao.deleteUserRole(empType);
	}
	
}
