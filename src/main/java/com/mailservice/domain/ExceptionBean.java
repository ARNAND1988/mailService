package com.mailservice.domain;

import javax.ws.rs.core.Response.StatusType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@XmlRootElement(name = "error")
@XmlAccessorType(FIELD)
public class ExceptionBean {

	private String status;
	private String code;
	private String error;
	private String errorMessage;
	private String messageID;
	private String errorInfo;
	private String key;
	@XmlTransient
	private StatusType httpStatus = BAD_REQUEST;

	public ExceptionBean() {
	}

	public ExceptionBean(String code, String messageID, String key, String errorInfo, String errorMessage) {
		super();
		this.code = code;
		this.messageID = messageID;
		this.key = key;
		this.errorInfo = errorInfo;
		this.errorMessage = errorMessage;
	}

	/**
	 * *
	 * This is used to get userFriendlyErrorInfo Eg: "Error returned from database."
	 *
	 * @param errorInfo
	 */
	public String getErrorInfo() {
		return errorInfo;
	}

	/**
	 * *
	 * This is used to set userFriendlyErrorInfo Eg: "Error returned from database."
	 *
	 * @param errorInfo
	 */
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	/**
	 * This is used to get the debug information required by the developer. Eg: method arguments
	 *
	 * @param errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * This is used to set the debug information required by the developer. Eg: method arguments
	 *
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public StatusType getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(StatusType httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getExceptionDetails() {
		return new StringBuilder()
				.append("Status: ").append(getStatus()).append("\n")
				.append("Code: ").append(getCode()).append("\n")
				.append("error ").append(getErrorMessage()).append("\n")
				.append("error message").append(getErrorMessage()).append("\n")
				.append("MessageId ").append(getMessageID()).append("\n")
				.append("Key ").append(getKey()).append("\n")
				.toString();

	}

}

