package com.gxun.chat.entity;

import com.gxun.java.response.GResponse;

public class SendResponse extends GResponse {
	private int status;
	private int id;
	private String message;

	public SendResponse() {

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
