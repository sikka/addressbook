package entities;

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
