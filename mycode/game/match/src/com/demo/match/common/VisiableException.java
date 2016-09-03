package com.demo.match.common;

public class VisiableException extends RuntimeException {

	private static final long serialVersionUID = 1703441382617268561L;

	public VisiableException(String message) {
		super(message);
	}
	
	public VisiableException(Exception e) {
		super(e);
	}
}
