package com.mailservice.service.helper;

import static org.apache.commons.lang.StringUtils.isBlank;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

import com.mailservice.domain.ExceptionBean;
import com.mailservice.domain.MailDetails;




@Component
public class MailServiceHelper extends BaseHelper{
	
	
	
	public void validateMailDetails(MailDetails mailDetails){
		List<ExceptionBean> exceptionBeanList = new ArrayList<ExceptionBean>(0);
		
//		if(isBlank(mailDetails.getTo()))	{
//			throw new RuntimeException("Empty email address for To");
//		} else {
//			if(!emailValidator.isValid(mailDetails.getTo())) {
//				exceptionBeanList.add(exceptionHandler.getGenericExceptionBean(CoreExceptionCodeConstants.INVALID_EMAIL,"Invalid Email address for To : "+mailDetails.getTo()));
//			}
//		}
		
		
	}
	
	public void populateEmailBodyFromTemplateAndData(MailDetails mailDetails) {
	}
	


}