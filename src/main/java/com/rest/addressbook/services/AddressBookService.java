package com.rest.addressbook.services;

import java.util.List;

import entities.Contact;
import entities.User;

public interface AddressBookService {
	String getAllContacts();
	Contact findContactByContactId(String contactId);
	String getContactsByUserId(String userId);
}
