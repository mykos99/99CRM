package com.synowiec.service.implementations;

import com.synowiec.dao.interfaces.UserDao;
import com.synowiec.dao.interfaces.UserRoleDao;
import com.synowiec.domain.User;
import com.synowiec.domain.UserRole;
import com.synowiec.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

 	@Autowired
	UserDao userDao;
	@Autowired
	UserRoleDao userRoleDao;

	@Override
	@Transactional
	public User findUserById(long id) {
		return userDao.findUser(id);
	};

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	};

	@Override
	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);
	};

	@Override
	@Transactional
	public void updateUser(User user){
		userDao.updateUser(user);
	};

	@Override
	@Transactional
	public void deleteUser(User user){
		userDao.deleteUser(user);
	};

	@Override
	@Transactional
	public UserRole findUserRoleById(long id) {
		return userRoleDao.findUserRole(id);
	}

	@Override
	@Transactional
	public List<UserRole> getAllUserRoles() {
		return userRoleDao.getAllUserRoles();
	}

	@Override
	@Transactional
	public void addUserRole(UserRole userRole) {
		userRoleDao.addUserRole(userRole);
	}

	@Override
	@Transactional
	public void updateUserRole(UserRole userRole) {
		userRoleDao.updateUserRole(userRole);
	}

	@Override
	@Transactional
	public void deleteUserRole(UserRole userRole) {
		userRoleDao.deleteUserRole(userRole);
	}
	
}
