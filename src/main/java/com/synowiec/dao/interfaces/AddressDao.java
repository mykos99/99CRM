package com.synowiec.dao.interfaces;

import com.synowiec.domain.Address;

import java.util.List;

public interface AddressDao {
	
	Address findAddress(long id);
	List<Address> getAllAddresses();
	void addAddress(Address address);
	void updateAddress(Address address);
	void deleteAddress(Address address);

}
