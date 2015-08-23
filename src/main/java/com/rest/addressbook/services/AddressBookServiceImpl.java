package com.rest.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entities.Contact;
import entities.User;
@Service
public class AddressBookServiceImpl implements AddressBookService {
	private static final List<User> userList = initDummyData();
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private static List<User> initDummyData() {
		List<User> userList = new ArrayList<User>();
		User user1 = new User("user1");
		User user2 = new User("user2");
		User user3 = new User("user3");
	
		List<Contact> userContactList = new ArrayList<Contact>();
		userContactList.add(new Contact("jack", "tyler", "1234567890", "jack@gmail.com", "NY"));
		userContactList.add(new Contact("jane", "honeywell", "2345678901", "jane@gmail.com", "NY"));
		userContactList.add(new Contact("jannet", "martha", "3456789012", "jannet@gmail.com", "NY"));
	
		userContactList.add(new Contact("joseph", "sunny", "4567890123", "jack@gmail.com", "NY"));
	
		userContactList.add(new Contact("julie", "dsouza", "5678901234", "julie@gmail.com", "CA"));
		userContactList.add(new Contact("jim", "amety", "6789012345", "jim@gmail.com", "CA"));
	
		userContactList.add(new Contact("jeff", " honeywell", "8901234567", "jeff@gmail.com", "CA"));
	
		userContactList.add(new Contact("jammy", "blake", "9012345678", "jammy@gmail.com", "CO"));
		userContactList.add(new Contact("jelly", "stallion", "0123456789", "jones@gmail.com", "CO"));
		userContactList.add(new Contact("adam", "stork", "11111111111", "adam@gmail.com", "CO"));
		user1.setContactList(userContactList);
		
		userContactList = new ArrayList<Contact>();
		
		userContactList.add(new Contact("jane", "janeice", "2345678901", "jane@gmail.com", "NY"));
		userContactList.add(new Contact("jammy", "jamm", "9012345678", "jammy@gmail.com", "CO"));
		userContactList.add(new Contact("adam", "adam", "11111111111", "adam@gmail.com", "CO"));
		userContactList.add(new Contact("bob", "bob", "2222222222", "bob@gmail.com", "NJ"));
		user2.setContactList(userContactList);
		
		userContactList = new ArrayList<Contact>();
		
		userContactList.add(new Contact("jack" , "jacksparrow", "1234567890", "jack@gmail.com", "NY"));
		userContactList.add(new Contact("jane", "janeice", "2345678901", "jane@gmail.com", "NY"));
		userContactList.add(new Contact("jammy", "jamm", "9012345678", "jammy@gmail.com", "CO"));
		userContactList.add(new Contact("bob", "bob", "2222222222", "bob@gmail.com", "NJ"));
		user3.setContactList(userContactList);
		

		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		return userList;
	}
	public Contact findContactByContactId(String contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Contact> getContactsByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllContacts() {
		return gson.toJson(userList);
	}
	

}
