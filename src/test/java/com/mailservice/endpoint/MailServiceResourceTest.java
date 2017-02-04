package com.mailservice.endpoint;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import com.mailservice.domain.MailDetails;
import com.mailservice.service.MailService;

public class MailServiceResourceTest {

	@Test
	public void testResource() {
		
		MailService mailService = Mockito.mock(MailService.class);
		MailDetails mailDetails = Mockito.mock(MailDetails.class);
		when(mailService.sendMail(mailDetails)).thenReturn(null);	
		mailService.sendMail(mailDetails);
		 verify(mailService, times(1)).sendMail(mailDetails);
	}

}
