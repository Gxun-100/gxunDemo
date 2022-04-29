package com.gxun.chat.entity;

import com.gxun.java.request.GRequest;

public class SendRequest extends GRequest {
	private String msg;
	private String nick;
	private String type;

	public SendRequest() {

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
