package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.UserDao;
import com.synowiec.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUser(long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    ;

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    ;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    ;

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    ;

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    ;
    
}
