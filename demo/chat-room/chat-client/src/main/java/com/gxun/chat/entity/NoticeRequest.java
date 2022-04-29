package com.gxun.chat.entity;

import java.util.ArrayList;
import java.util.List;

import com.gxun.java.request.GRequest;

public class NoticeRequest extends GRequest {
	private List<Message> msglist;

	public NoticeRequest() {
		msglist = new ArrayList<Message>();
	}

	public List<Message> getMsglist() {
		return msglist;
	}

	public void setMsglist(List<Message> msglist) {
		this.msglist = msglist;
	}

}
