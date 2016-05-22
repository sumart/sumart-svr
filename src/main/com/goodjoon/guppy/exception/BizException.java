package com.goodjoon.guppy.exception;

public class BizException extends RuntimeException {
	protected static String CODE_UNKNOWN = "Unknown";
	
	protected String code;
	
	public BizException (String message) {
		super(message);
		code = "[" + CODE_UNKNOWN+ "]";
	}
	
	public BizException (String code, String message) {
		super(message);
		this.code = code;
	}
	
	public BizException (String message, Throwable cause) {
		super(message, cause);
		code = "[" + CODE_UNKNOWN + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public void setCode(int code) {
		this.code = String.valueOf(code);
	}
}
