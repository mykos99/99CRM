package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.ContactDao;
import com.synowiec.domain.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("ContactDao")
public class ContactDaoImpl implements ContactDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Contact findContact(long id) {
        return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
    }

    ;

    @Override
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession().createCriteria(Contact.class).list();
    }

    ;

    @Override
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().persist(contact);
    }

    ;

    @Override
    public void updateContact(Contact contact) {
        sessionFactory.getCurrentSession().update(contact);
    }

    ;

    @Override
    public void deleteContact(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
    }

    ;

}
