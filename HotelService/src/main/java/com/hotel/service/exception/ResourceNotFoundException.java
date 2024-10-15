package com.hotel.service.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Resource Hotel Not Found on Server");
	}

	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
