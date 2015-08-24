package com.rest.adressbook.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import entities.Contact;

public class AddressbookUtils {
	static int id = 1234;
	public static String getUniqueId() {
		return (Integer.toString(id++));
	}
	
	public static List<Contact> sort(List<Contact> contacts, final String field) {
		Collections.sort(contacts, new Comparator<Contact>(){
		     public int compare(Contact c1, Contact c2){
		    	 switch (field != null ? field : "") {
		    	 case "firstName":
		    		 return c1.getFirstName().compareTo(c2.getFirstName());
		    	 case "lastName":
		    		 return c1.getLastName().compareTo(c2.getLastName());
		    	 default:
		    		 return c1.getContactId().compareTo(c2.getContactId());
		    	 }
		     }
		});
		return contacts;
		
	}
}
