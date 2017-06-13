package com.synowiec.dao.interfaces;

import com.synowiec.domain.Contact;
import com.synowiec.domain.Customer;

import java.util.List;

public interface CustomerDao {

	Customer findCustomer(long id);
	List<Customer> getAllCustomers();
	void addCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	List<Contact> lazyLoadCustomerContacts(Customer customer);

}
