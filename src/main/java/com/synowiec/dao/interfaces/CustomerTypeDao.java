package com.synowiec.dao.interfaces;

import com.synowiec.domain.CustomerType;

import java.util.List;

public interface CustomerTypeDao {
	CustomerType findCustomerType(long id);
	List<CustomerType> getAllCustomerTypes();
	void addCustomerType(CustomerType custType);
	void updateCustomerType(CustomerType custType);
	void deleteCustomerType(CustomerType custType);
}
