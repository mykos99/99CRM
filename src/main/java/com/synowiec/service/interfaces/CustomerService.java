package com.synowiec.service.interfaces;

import com.synowiec.domain.Address;
import com.synowiec.domain.Contact;
import com.synowiec.domain.Customer;
import com.synowiec.domain.CustomerType;

import java.util.List;

public interface CustomerService {
	Customer findCustomerById(long id);
	List<Customer> getAllCustomers();
	void addCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	List<Contact> getCustomerContacts(Customer customer);
	
	CustomerType findCustomerTypeById(long id);
	List<CustomerType> getAllCustomerTypes();
	void addCustomerType(CustomerType custType);
	void updateCustomerType(CustomerType custType);
	void deleteCustomerType(CustomerType custType);
	
	Address findAddressById(long id);
	List<Address> getAllAddresses();
	void addAddress(Address address);
	void updateAddress(Address address);
	void deleteAddress(Address address);
	
	Contact findContactById(long id);
	List<Contact> getAllContacts();
	void addContact(Contact contact);
	void updateContact(Contact contact);
	void deleteContact(Contact contact);

}
