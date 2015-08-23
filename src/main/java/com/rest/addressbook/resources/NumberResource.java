package com.rest.addressbook.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/numbers")
public class NumberResource {
	@GET
	public String getAllContacts() {
		return "213-400-3498, 213-880-0243";
	}
}
