package com.mailservice.service;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.mailservice.domain.MailDetails;
import com.mailservice.domain.SendMailResponse;
import com.mailservice.service.helper.MailServiceHelper;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class MailService {
	
	private MailServiceHelper mailServiceHelper = new MailServiceHelper();
	
	//@Autowired
	//private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	
	String fromAddress;
		
	JavaMailSenderImpl mailSender; 
	
	FreeMarkerConfigurer freemarkerConfig;
	
	/*
	public MailService(){
		mailSender.setHost("WL22INDINT01.ind.emea.williamslea.grp");
		mailSender.setPort(25);
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", false);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.mime.charset", "UTF-8");
		mailSender.setJavaMailProperties(prop);
		
	}
*/
	public SendMailResponse sendMail(MailDetails mailDetails){
		
		System.out.println("mailSender "+mailSender.toString());
//		if(true)return null;
		mailServiceHelper.validateMailDetails(mailDetails);
//		mailServiceHelper.populateEmailBodyFromTemplateAndData(mailDetails);
		String cid = UUID.randomUUID().toString();
		SendMailResponse resp = new SendMailResponse();
		String filePath = null;
		try {
			
			Configuration cfg1 = freemarkerConfig.getConfiguration();
			Template template = cfg1.getTemplate("html-mail-template.ftl");
			
			filePath =	decodeImg(mailDetails.getImageStr());
			
			
            HashMap rootMap = new HashMap<String, String>();                    
            rootMap.put("cid", cid);
           
            Writer out = new StringWriter();
            template.process(rootMap, out);
			MimeMessage message = mailSender.createMimeMessage();
			

			
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
			
			if (mailDetails.getFrom() != null && !mailDetails.getFrom().isEmpty()){
				helper.setFrom(mailDetails.getFrom());
			}
			else {
				helper.setFrom(fromAddress);
			}
			helper.setSubject(mailDetails.getSubject());
			helper.setTo(mailDetails.getTo());			
			helper.setText(out.toString(),true);
			helper.addInline(cid, new File(filePath));
			
			mailSender.send(message);
			
			resp.setDate(new Date());
			resp.setMessage("Mail Sent Successfully");
			resp.setErrorCode(Response.Status.OK.toString());
			return resp;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
//			throw new SendMailException(exceptionHandler.getGenericExceptionBean(CoreExceptionCodeConstants.MAIL_SEND_FAILED,"Exception occured : "+e.getClass().getSimpleName()+" : "+ e.getMessage()));
		}finally{
			deleteImg(filePath);
		}
	}
	
	
	String generateUniqueFileName() {
	    String filename = "";
	    long millis = System.currentTimeMillis();
	    String datetime = new Date().toGMTString();
	    datetime = datetime.replace(" ", "");
	    datetime = datetime.replace(":", "");
	    String rndchars = RandomStringUtils.randomAlphanumeric(16);
	    filename = rndchars + "_" + datetime + "_" + millis;
	    return filename+".jpeg";
	}

	
	public String decodeImg(String base64ImageString) throws Exception {
		//File dir = new File("WB/Temp");
		File file = new File(generateUniqueFileName());
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        writer.write(new sun.misc.BASE64Decoder().decodeBuffer(base64ImageString.split(",")[1]));
        writer.flush();
        writer.close();
		return file.getAbsolutePath();
    }
	
	public void deleteImg(String filePath){
		if(filePath!=null){
		File file = new File(filePath);
		if(file.delete()){
			System.out.println(file.getName() + " is deleted!");
		}else{
			System.out.println("Delete operation is failed.");
		}
		}
	}
	
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}


	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}


	public void setFreemarkerConfig(FreeMarkerConfigurer freemarkerConfig) {
		this.freemarkerConfig = freemarkerConfig;
	}

	private void setMailDetails(MailDetails mailDetails,MimeMessageHelper helper) throws MessagingException {
		
		if (!StringUtils.isBlank(mailDetails.getCc())) {
			helper.setCc(mailDetails.getCc());
		}
		
		if (!StringUtils.isBlank(mailDetails.getBcc())) {
			helper.setBcc(mailDetails.getBcc());
		}
		
		if (!StringUtils.isBlank(mailDetails.getReplyTo())) {
			helper.setReplyTo(mailDetails.getReplyTo());
		}
		
		if (!StringUtils.isBlank(mailDetails.getHtmlBody())) {
			helper.setText(mailDetails.getHtmlBody(), true);
		}
		else if (!StringUtils.isBlank(mailDetails.getTextBody())) 
		{
			helper.setText(mailDetails.getTextBody(), false);
		} else {
			helper.setText("", false);
		}
		
		if (!StringUtils.isBlank(mailDetails.getSubject())) {
			helper.setSubject(mailDetails.getSubject());
		}
		
		// determines if there is an upload file, attach it to the e-mail		
        if (mailDetails.getAttachFile()!=null) {
        	File file = mailDetails.getAttachFile();
        	helper.addAttachment(file.getName(), file);
        }
	}
}

