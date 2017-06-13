package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.EmployeeDao;
import com.synowiec.domain.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("EmployeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee findEmployee(long id) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    ;

    @Override
    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
    }

    ;

    @Override
    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().persist(employee);
    }

    ;

    @Override
    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    ;

    @Override
    public void deleteEmployee(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    ;
    
}
