package com.rest.addressbook.services;

import entities.Contact;

public interface AddressBookService {
	String getAllContacts();
	Contact findContactByContactId(String contactId);
	String getContactsByUserId(String userId, String sortby, String searchval);
	String getUserDetails(String id);
	String createUserContact(String id, String json);
	String createUser(String json);
	String createOrModifyUserContact(String userId, String json);
	void deleteUser(String userId);
	void deleteUserContact(String userId, String contactId);
}
