package com.rest.addressbook.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.addressbook.services.AddressBookService;
import com.rest.addressbook.services.AddressBookServiceImpl;

@Path("/v1/users/")
public class UsersResource {
	// Use Spring dependency injection later.
	private AddressBookService svc = new AddressBookServiceImpl();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllContacts() {
		String response = svc.getAllContacts();
		return Response.ok(response.getBytes(), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getContactsForUser(@PathParam("id") String id) {
		return svc.getContactsByUserId(id).toString();
	}
}
