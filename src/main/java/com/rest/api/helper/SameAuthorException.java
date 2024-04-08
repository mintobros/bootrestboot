package com.rest.api.helper;

public class SameAuthorException extends Throwable {
	
	private String msg;

	public SameAuthorException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "SameAuthorException [msg=" + msg + "]";
	}
	

}
