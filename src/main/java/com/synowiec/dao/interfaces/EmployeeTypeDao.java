package com.synowiec.dao.interfaces;

import com.synowiec.domain.EmployeeType;

import java.util.List;


public interface EmployeeTypeDao  {

    EmployeeType findEmployeeType(long id);
    List<EmployeeType> getAllEmployeeTypes();
    void addEmployeeType(EmployeeType employeeType);
    void updateEmployeeType(EmployeeType employeeType);
    void deleteEmployeeType(EmployeeType employeeType);

}

