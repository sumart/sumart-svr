package com.goodjoon.guppy.exception;

public class GuppyException extends Exception {
	protected int code;
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public GuppyException(Exception cause) {
		super(cause);
	}
	
	public GuppyException(String message) {
		super(message);
	}
	
	public GuppyException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public GuppyException(int code, String message, Throwable cause) {
		super(message, cause);
		setCode(code);
	}
	
	public GuppyException(int code, String message) {
		super(message);
		setCode(code);
	}
}
