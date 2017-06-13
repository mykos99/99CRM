package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.AddressDao;
import com.synowiec.domain.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("AddressDao")
public class AdressDaoImpl implements AddressDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Address findAddress(long id) {
        return (Address) sessionFactory.getCurrentSession().get(Address.class, id);
    }

    ;

    @Override
    public List<Address> getAllAddresses() {
        return sessionFactory.getCurrentSession().createCriteria(Address.class).list();
    }

    ;

    @Override
    public void addAddress(Address address) {
        sessionFactory.getCurrentSession().persist(address);
    }

    ;

    @Override
    public void updateAddress(Address address) {
        sessionFactory.getCurrentSession().update(address);
    }

    ;

    @Override
    public void deleteAddress(Address address) {
        sessionFactory.getCurrentSession().delete(address);
    }

    ;

}
