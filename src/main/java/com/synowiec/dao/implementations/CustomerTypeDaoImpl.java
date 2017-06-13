package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.CustomerTypeDao;
import com.synowiec.domain.CustomerType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("CustomerTypeDao")
public class CustomerTypeDaoImpl implements CustomerTypeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public CustomerType findCustomerType(long id) {
        return (CustomerType) sessionFactory.getCurrentSession().get(CustomerType.class, id);
    }

    ;

    @Override
    public List<CustomerType> getAllCustomerTypes() {
        return sessionFactory.getCurrentSession().createCriteria(CustomerType.class).list();
    }

    ;

    @Override
    public void addCustomerType(CustomerType custType) {
        sessionFactory.getCurrentSession().persist(custType);
    }

    ;

    @Override
    public void updateCustomerType(CustomerType custType) {
        sessionFactory.getCurrentSession().update(custType);
    }

    ;

    @Override
    public void deleteCustomerType(CustomerType custType) {
        sessionFactory.getCurrentSession().delete(custType);
    }

    ;

}
