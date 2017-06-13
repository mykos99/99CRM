package com.synowiec.dao.interfaces;

import com.synowiec.domain.Contact;

import java.util.List;

public interface ContactDao {
	
	Contact findContact(long id);
	List<Contact> getAllContacts();
	void addContact(Contact contact);
	void updateContact(Contact contact);
	void deleteContact(Contact contact);

}
