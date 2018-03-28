package com.prosegur.rulesEngine.services.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ServiceException extends Exception {
	private static final long serialVersionUID = -5870153789360850120L;
	
	public ServiceException(String message) {
		super(message);
	}
}