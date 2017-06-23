package com.synowiec.dao.interfaces;

import com.synowiec.domain.User;

import java.util.List;

public interface UserDao {
	User findUser(long id);
	List<User> getAllUsers();
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
}
