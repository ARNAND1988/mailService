package com.mailservice.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mailservice.domain.MailDetails;
import com.mailservice.domain.SendMailResponse;
import com.mailservice.service.MailService;


@Component
@Path("/sendmail")
public class MailServiceResource {
	
	@Autowired
	MailService mailService;
	
	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })	
	public Response sendMail(MailDetails mailDetails) {
		SendMailResponse resp = mailService.sendMail(mailDetails);
		return Response.status(Response.Status.OK).entity(resp).build();
	}
	
	@GET
	@Produces("text/plain")
	public String getEmail(){
		MailDetails mailDetails = new MailDetails();
		mailDetails.setFrom("deepak.natakala@gmail.com");
		
		String[] mail = {"deepak.natakala@williamslea.com", "Anand.parasuraman@williamslea.com"};	
		
		mailDetails.setTo(mail);
		mailService.sendMail(mailDetails);
		return "";
		
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public MailService getMailService() {
		return mailService;
	}

}
