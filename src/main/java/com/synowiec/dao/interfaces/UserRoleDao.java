package com.synowiec.dao.interfaces;

import com.synowiec.domain.UserRole;

import java.util.List;


public interface UserRoleDao {

    UserRole findUserRole(long id);
    List<UserRole> getAllUserRoles();
    void addUserRole(UserRole userRole);
    void updateUserRole(UserRole userRole);
    void deleteUserRole(UserRole userRole);

}

