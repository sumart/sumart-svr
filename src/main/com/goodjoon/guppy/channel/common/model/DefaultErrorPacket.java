package com.goodjoon.guppy.channel.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DefaultErrorPacket {
	@JsonInclude(Include.ALWAYS)
	protected String code;
	
	@JsonInclude(Include.ALWAYS)
	protected String message;
	
	@JsonInclude(Include.NON_NULL)
	protected Throwable cause;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

}
