package com.rest.addressbook.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(String json) {
		String userId = svc.createUser(json);
		return Response.status(Status.CREATED).entity("User created successfully! UserId assigned is "+userId).build();
	}
	
	@GET
	@Path("{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserDetails(@PathParam("id") String id) {
		String userDetails = svc.getUserDetails(id);
		Response response =  Response.ok(userDetails, MediaType.APPLICATION_JSON).build();
		return response;
	}
	
	@GET
	@Path("{id: \\d+}/contacts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getContactsForUser(@Context UriInfo info) {
		String id = info.getPathParameters().getFirst("id");
		String sortby = info.getQueryParameters().getFirst("sortby");
		String searchval = info.getQueryParameters().getFirst("searchval");
		String contactList = svc.getContactsByUserId(id, sortby, searchval);
		System.out.println(contactList);
		Response response =  Response.ok(contactList, MediaType.APPLICATION_JSON).build();
		return response;
	}
	
	@POST
	@Path("{id: \\d+}/contacts")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createContactsForUser(@PathParam("id") String userId, String json) {
		//String userId = srv.createUserContactList
		String contactId = svc.createUserContact(userId, json);
		return Response.status(Status.CREATED).entity("created the user. Id assigned to the contact is "+contactId).build();
	}
	
	@PUT
	@Path("{id: \\d+}/contacts")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createOrModifyUserContacts(@PathParam("id") String userId, String json) {
		String contactJson = svc.createOrModifyUserContact(userId, json);
		return Response.ok(contactJson, MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("{id: \\d+}")
	public Response deleteUser(@PathParam("id") String userId) {
		svc.deleteUser(userId);
		return Response.ok("Deleted successfully").build();
	}
	
	@DELETE
	@Path("{id: \\d+}/contacts/{contactId: \\d+}")
	public Response deleteUserContact(@Context UriInfo info) {
		String userId = info.getPathParameters().getFirst("id");
		String contactId = info.getPathParameters().getFirst("contactId");
		svc.deleteUserContact(userId, contactId);
		return Response.ok("Deleted successfully").build();
	}
	
}
