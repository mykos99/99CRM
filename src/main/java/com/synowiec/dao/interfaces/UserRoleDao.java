package com.synowiec.dao.interfaces;

import com.synowiec.domain.UserRole;

import java.util.List;


public interface EmployeeTypeDao  {

    UserRole findEmployeeType(long id);
    List<UserRole> getAllEmployeeTypes();
    void addEmployeeType(UserRole userRole);
    void updateEmployeeType(UserRole userRole);
    void deleteEmployeeType(UserRole userRole);

}

