package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.CustomerDao;
import com.synowiec.domain.Contact;
import com.synowiec.domain.Customer;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("CustomerDao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Customer findCustomer(long id){
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
	};

	@Override
	public List<Customer> getAllCustomers() {
		return sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	};

	@Override
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().persist(customer);
	};

	@Override
	public void updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
	};

	@Override
	public void deleteCustomer(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);
	}

	@Override
	public List<Contact> lazyLoadCustomerContacts(Customer customer) {
		sessionFactory.getCurrentSession().refresh(customer);
		Hibernate.initialize(customer.getContacts());
		return customer.getContacts();
	}
}
