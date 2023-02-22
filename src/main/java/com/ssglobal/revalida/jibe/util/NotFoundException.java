package com.ssglobal.revalida.jibe.util;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
	public NotFoundException() {
		super();
	}
	
	public NotFoundException(final String message) {
		super(message);
	}
}
