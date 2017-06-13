package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.EmployeeTypeDao;
import com.synowiec.domain.EmployeeType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("EmployeeTypeDao")
public class EmployeeTypeDaoImpl implements EmployeeTypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public EmployeeType findEmployeeType(long id) {
        return (EmployeeType) sessionFactory.getCurrentSession().get(EmployeeType.class, id);
    }

    ;

    @Override
    public List<EmployeeType> getAllEmployeeTypes() {
        return sessionFactory.getCurrentSession().createCriteria(EmployeeType.class).list();
    }

    @Override
    public void addEmployeeType(EmployeeType empType) {
        sessionFactory.getCurrentSession().persist(empType);
    }

    ;

    @Override
    public void updateEmployeeType(EmployeeType empType) {
        sessionFactory.getCurrentSession().update(empType);
    }

    ;

    @Override
    public void deleteEmployeeType(EmployeeType empType) {
        sessionFactory.getCurrentSession().delete(empType);
    }

    ;

}
