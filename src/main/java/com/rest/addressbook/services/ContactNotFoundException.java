package com.rest.addressbook.services;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ContactNotFoundException extends WebApplicationException {
	private static final long serialVersionUID = 1L;
	public ContactNotFoundException() {
		super();
	}
	
	public ContactNotFoundException(String msg) {
		super(Response.status(Status.NOT_FOUND).entity(msg).type(MediaType.TEXT_PLAIN).build());
	}
	
	public ContactNotFoundException(Status status, String msg) {
		super(Response.status(status).entity(msg).type(MediaType.TEXT_PLAIN).build());
	}
}
