package com.goodjoon.guppy.channel.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DefaultResponse {
	
	/**
	 * 성공이면 "OK", 아니면 "ERROR"
	 */
	@JsonInclude(Include.ALWAYS)
	protected String success;
	
	@JsonInclude(Include.NON_NULL)
	protected DefaultErrorPacket error;
	
	@JsonInclude(Include.NON_NULL)
	protected Object result;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}


	public DefaultErrorPacket getError() {
		return error;
	}

	public void setError(DefaultErrorPacket error) {
		this.error = error;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	
}
