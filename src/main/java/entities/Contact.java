package entities;

import com.rest.adressbook.utils.AddressbookUtils;

public class Contact {
	private String firstName;
	private String lastName;
	private String contactId;
	private String emailAddress;
	private String phoneNumber;
	private String residenceAddress;
	
	public Contact(String firstName, String lastName, String phoneNumber, String emailAddress, String residenceAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.residenceAddress = residenceAddress;
		this.contactId = AddressbookUtils.getUniqueId();
	}
	public Contact(Contact contact) {
		this(contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), contact.getEmailAddress(), contact.getResidenceAddress());
	}
	public Contact(Contact contact, String contactId) {
		this(contact);
		this.setContactId(contactId);
		System.out.println("contactId passed::"+contactId);
		System.out.println("contactId after set ::"+this.getContactId());
	}
	public String getFullName() {
		return firstName+" "+lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String userId) {
		this.contactId = userId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getResidenceAddress() {
		return residenceAddress;
	}
	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}
	
	@Override
	public String toString() {
		return "Contact [firstName="+this.firstName+", lastName="+this.lastName+", contactId="+this.contactId+", emailAddress="
				+this.emailAddress+", phoneNumber="+this.phoneNumber+", residenceAddress="+this.residenceAddress+"]";
	}
}
