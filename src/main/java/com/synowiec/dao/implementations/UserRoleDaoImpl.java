package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.UserRoleDao;
import com.synowiec.domain.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UserRole findUserRole(long id) {
        return (UserRole) sessionFactory.getCurrentSession().get(UserRole.class, id);
    }

    ;

    @Override
    public List<UserRole> getAllUserRoles() {
        return sessionFactory.getCurrentSession().createCriteria(UserRole.class).list();
    }

    @Override
    public void addUserRole(UserRole empType) {
        sessionFactory.getCurrentSession().persist(empType);
    }

    ;

    @Override
    public void updateUserRole(UserRole empType) {
        sessionFactory.getCurrentSession().update(empType);
    }

    ;

    @Override
    public void deleteUserRole(UserRole empType) {
        sessionFactory.getCurrentSession().delete(empType);
    }

    ;

}
