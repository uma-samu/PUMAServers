package com.rackspace.testpuma.exceptions;

import javax.xml.bind.annotation.XmlRootElement;

/**
* This is the model class for capturing Error Details 
* when an exception is raised
*
* @author  Umadevi Samudrala
* @version 1.0
* @since   2016-05-25 
*/
@XmlRootElement
public class ErrorDetail {

	private int errorCode;
	
	private String errorMsg;
	
	private String errorDetails;
	
	public ErrorDetail(){
		
	}
	
	public ErrorDetail(int errorCode, String errorMsg, String errorDetails){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.errorDetails = errorDetails;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
}
