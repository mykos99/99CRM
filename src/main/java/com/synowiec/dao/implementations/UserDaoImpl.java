package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.EmployeeDao;
import com.synowiec.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EmployeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findEmployee(long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    ;

    @Override
    public List<User> getAllEmployees() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    ;

    @Override
    public void addEmployee(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    ;

    @Override
    public void updateEmployee(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    ;

    @Override
    public void deleteEmployee(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    ;
    
}
