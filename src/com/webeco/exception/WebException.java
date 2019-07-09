package com.webeco.exception;

public class WebException extends Exception{

private String details;
	
	public WebException(String details) {
		super();
		this.details = details;
	}

	public String getDetails() {
		return details;
	}
}
