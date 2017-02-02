package com.mailservice.domain;

import java.io.File;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.mailservice.util.JaxbIntegerMarshlar;

@javax.xml.bind.annotation.XmlRootElement(name = "payload")
public class MailDetails {

	private String from;
	private String to[];
	private String cc;
	private String bcc;
	private String subject;
	private String htmlBody;
	private String textBody;
	private String replyTo;
	private String siteId;
	private Integer templateId;
	private List<Data> dataSet;
	private File attachFile;
	private String imageStr;
	
	@XmlElement
	public String getImageStr() {
		return imageStr;
	}

	public void setImageStr(String imageStr) {
		this.imageStr = imageStr;
	}

	/**
	 * @return the templateId
	 */
	@XmlJavaTypeAdapter(JaxbIntegerMarshlar.class)
	@XmlElement
	public Integer getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the dataSet
	 */
	@XmlElementWrapper(name="dataSet")
	@XmlElement(name="data")
	public List<Data> getDataSet() {
		return dataSet;
	}

	/**
	 * @param dataSet the dataSet to set
	 */
	public void setDataSet(List<Data> dataSet) {
		this.dataSet = dataSet;
	}

	/**
	 * @return the from
	 */
	@XmlElement
	public String getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	@XmlElement
	public String[] getTo() {
		return to;
	}

	/**
	 * @param to
	 *            the to to set
	 */
	public void setTo(String to[]) {
		this.to = to;
	}

	/**
	 * @return the cc
	 */
	@XmlElement
	public String getCc() {
		return cc;
	}

	/**
	 * @param cc
	 *            the cc to set
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}

	/**
	 * @return the bcc
	 */
	@XmlElement
	public String getBcc() {
		return bcc;
	}

	/**
	 * @param bcc
	 *            the bcc to set
	 */
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	/**
	 * @return the subject
	 */
	@XmlElement
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the htmlBody
	 */
	@XmlElement
	public String getHtmlBody() {
		return htmlBody;
	}

	/**
	 * @param htmlBody
	 *            the htmlBody to set
	 */
	public void setHtmlBody(String htmlBody) {
		this.htmlBody = htmlBody;
	}

	/**
	 * @return the textBody
	 */
	@XmlElement
	public String getTextBody() {
		return textBody;
	}

	/**
	 * @param textBody
	 *            the textBody to set
	 */
	public void setTextBody(String textBody) {
		this.textBody = textBody;
	}

	/**
	 * @return the replyTo
	 */
	@XmlElement
	public String getReplyTo() {
		return replyTo;
	}

	/**
	 * @param replyTo
	 *            the replyTo to set
	 */
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}

	/**
	 * @return the siteId
	 */
	@XmlElement
	public String getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId
	 *            the siteId to set
	 */
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	@XmlElement
	public File getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(File attachFile) {
		this.attachFile = attachFile;
	}
}