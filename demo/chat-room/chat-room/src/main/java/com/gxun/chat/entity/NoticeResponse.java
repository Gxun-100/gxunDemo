package com.gxun.chat.entity;

import com.gxun.java.response.GResponse;

public class NoticeResponse extends GResponse{
	private int status;
	private String message;

	public NoticeResponse() {

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
