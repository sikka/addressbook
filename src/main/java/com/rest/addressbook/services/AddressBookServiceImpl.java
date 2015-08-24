package com.rest.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rest.adressbook.utils.AddressbookUtils;

import entities.Contact;
import entities.User;

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
	
		userContactList.add(new Contact("jeff", "honeywell", "8901234567", "jeff@gmail.com", "CA"));
	
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
	
	@Override
	public Contact findContactByContactId(String contactId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getContactsByUserId(String userId, String sortby, String searchval) throws UserNotFoundException, ContactNotFoundException {
		for (User user: userList) {
			if (userId.equals(user.getUserId())) {
				List<Contact> contactList = new ArrayList<Contact>();
				for (Contact contact : user.getContactList()) {
					if (contact.toString().contains(StringUtils.isBlank(searchval) ? "" : searchval)) {
						contactList.add(contact);
					}
				}
				if (contactList.size() == 0) {
					throw new ContactNotFoundException(Status.NO_CONTENT, "No records match the given search criteria");
				}
				return gson.toJson(AddressbookUtils.sort(contactList, sortby));
			}
		}
		throw new UserNotFoundException("User with Id "+userId+" does not exist");
	}
	
	@Override
	public String getAllContacts() {
		return gson.toJson(userList);
	}
	
	@Override
	public String getUserDetails(String id) {
		for (User user : userList) {
			if (user.getUserId().equals(id)) {
				return gson.toJson(user);
			}
		}
		throw new UserNotFoundException("User with Id "+id+" does not exist");
	}

	@Override
	public String createUserContact(String userId, String json) {
		Contact contact = new Contact(gson.fromJson(json, Contact.class));
		boolean userFound = false;
		for (User user : userList) {
			if (user.getUserId().equals(userId)) {
				userFound = true;
				user.getContactList().add(contact);
				return contact.getContactId();
			}
		}
		if (!userFound){
			throw new UserNotFoundException("User with Id "+userId+" does not exist");
		}
		return "User not found";
	}

	@Override
	public String createUser(String json) {
		User user = new User(gson.fromJson(json, User.class));
		userList.add(user);
		return user.getUserId();
	}
}
