package entities;

import java.util.ArrayList;
import java.util.List;

import com.rest.adressbook.utils.AddressbookUtils;

public class User {
	private String userName;
	private String userId;
	private List<Contact> contactList = null;
	
	public User(String userName) {
		this.userName = userName;
		this.userId = AddressbookUtils.getUniqueId();
	}
	public User(User user) {
		this(user.userName);
		List<Contact> contactList = new ArrayList<Contact>();
		// we want the contact ids to be different for the new list.
		// also, single list cannot be the contact list of multiple users.
		for (Contact contact: user.getContactList()) {
			contactList.add(new Contact(contact));
		}
		this.setContactList(contactList);
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<Contact> getContactList() {
		return contactList;
	}
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	
	@Override
	public String toString() {
		StringBuilder userString = new StringBuilder("User [userName="+this.userName+", userId="+this.userId+", Contacts=");
		for (Contact contact : this.contactList) {
			userString.append(contact.toString());
		}
		userString.append("]");
		return userString.toString();
	}
	
	
}
