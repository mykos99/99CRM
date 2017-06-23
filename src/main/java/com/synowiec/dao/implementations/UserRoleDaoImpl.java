package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.EmployeeTypeDao;
import com.synowiec.domain.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EmployeeTypeDao")
public class EmployeeTypeDaoImpl implements EmployeeTypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UserRole findEmployeeType(long id) {
        return (UserRole) sessionFactory.getCurrentSession().get(UserRole.class, id);
    }

    ;

    @Override
    public List<UserRole> getAllEmployeeTypes() {
        return sessionFactory.getCurrentSession().createCriteria(UserRole.class).list();
    }

    @Override
    public void addEmployeeType(UserRole empType) {
        sessionFactory.getCurrentSession().persist(empType);
    }

    ;

    @Override
    public void updateEmployeeType(UserRole empType) {
        sessionFactory.getCurrentSession().update(empType);
    }

    ;

    @Override
    public void deleteEmployeeType(UserRole empType) {
        sessionFactory.getCurrentSession().delete(empType);
    }

    ;

}
