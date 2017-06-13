package com.synowiec.service.implementations;

import com.synowiec.dao.interfaces.*;
import com.synowiec.domain.Address;
import com.synowiec.domain.Contact;
import com.synowiec.domain.Customer;
import com.synowiec.domain.CustomerType;
import com.synowiec.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;
    @Autowired
    CustomerTypeDao customerTypeDao;
    @Autowired
    AddressDao addressDao;
    @Autowired
    ContactDao contactDao;
    @Autowired
    EmployeeDao employeeDao;

    @Override
    @Transactional
    public Customer findCustomerById(long id) {
        return customerDao.findCustomer(id);
    }

    ;

    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    ;

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        customer.setCustType(this.findCustomerTypeById(customer.getCustType().getId()));
        customer.setSalesman((employeeDao.findEmployee(customer.getSalesman().getId())));
        this.addAddress(customer.getAddress());
        customerDao.addCustomer(customer);
    }

    ;

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customer.setCustType(this.findCustomerTypeById(customer.getCustType().getId()));
        customer.setSalesman((employeeDao.findEmployee(customer.getSalesman().getId())));
        this.updateAddress(customer.getAddress());
        customerDao.updateCustomer(customer);
    }

    ;

    @Override
    @Transactional
    public void deleteCustomer(Customer customer) {
        customerDao.deleteCustomer(customer);
    }

    @Override
    @Transactional
    public List<Contact> getCustomerContacts(Customer customer) {
        return customerDao.lazyLoadCustomerContacts(customer);
    }

    @Override
    @Transactional
    public CustomerType findCustomerTypeById(long id) {
        return customerTypeDao.findCustomerType(id);
    }

    ;

    @Override
    @Transactional
    public List<CustomerType> getAllCustomerTypes() {
        return customerTypeDao.getAllCustomerTypes();
    }

    ;

    @Override
    @Transactional
    public void addCustomerType(CustomerType custType) {
        customerTypeDao.addCustomerType(custType);
    }

    ;

    @Override
    @Transactional
    public void updateCustomerType(CustomerType custType) {
        customerTypeDao.updateCustomerType(custType);
    }

    ;

    @Override
    @Transactional
    public void deleteCustomerType(CustomerType custType) {
        customerTypeDao.deleteCustomerType(custType);
    }

    ;

    @Override
    @Transactional
    public Address findAddressById(long id) {
        return addressDao.findAddress(id);
    }

    @Override
    @Transactional
    public List<Address> getAllAddresses() {
        return addressDao.getAllAddresses();
    }

    @Override
    @Transactional
    public void addAddress(Address address) {
        addressDao.addAddress(address);
    }

    @Override
    @Transactional
    public void updateAddress(Address address) {
        addressDao.updateAddress(address);
    }

    @Override
    @Transactional
    public void deleteAddress(Address address) {
        addressDao.deleteAddress(address);
    }

    @Override
    @Transactional
    public Contact findContactById(long id) {
        return contactDao.findContact(id);
    }

    @Override
    @Transactional
    public List<Contact> getAllContacts() {
        return contactDao.getAllContacts();
    }

    @Override
    @Transactional
    public void addContact(Contact contact) {
        contactDao.addContact(contact);
    }

    @Override
    @Transactional
    public void updateContact(Contact contact) {
        contactDao.updateContact(contact);
    }

    @Override
    @Transactional
    public void deleteContact(Contact contact) {
        contactDao.deleteContact(contact);
    }

}
