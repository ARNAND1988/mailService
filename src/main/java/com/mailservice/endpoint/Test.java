package com.mailservice.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
public class Test {
	
	@GET
	@Produces("text/plain")
	public String get(){
		return "Hello REST";
	}

}
