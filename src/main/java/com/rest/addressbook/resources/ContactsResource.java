package com.rest.addressbook.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.http.MediaType;

import com.rest.addressbook.services.AddressBookService;
import com.rest.addressbook.services.AddressBookServiceImpl;

import entities.User;

@Path("/v1/users/")
public class ContactsResource {
	private AddressBookService svc = new AddressBookServiceImpl();
	@GET
	@Produces("application/json")
	public String getAllContacts() {
		return svc.getAllContacts().toString();
	}
}
