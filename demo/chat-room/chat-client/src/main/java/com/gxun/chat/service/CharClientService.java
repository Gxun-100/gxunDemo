package com.gxun.chat.service;

import java.util.LinkedList;
import java.util.List;

import com.gxun.chat.entity.Message;
import com.gxun.chat.entity.NoticeRequest;
import com.gxun.chat.entity.NoticeResponse;
import com.gxun.chat.entity.SendResponse;
import com.gxun.core.GxunException;
import com.gxun.core.GxunRequest;
import com.gxun.java.annotation.GxunMethodAnno;
import com.gxun.java.service.GService;

public class CharClientService extends GService {

	private static int mid = 0;
	private final static List<Message> msgdb = new LinkedList<Message>();

	@GxunMethodAnno(method = "NOTICE", protocolId = 30, protocolName = "聊天室", protocolVer = "1.0")
	public void onDataArrive_Notice(GxunRequest gxunRequest) throws GxunException {
		
		NoticeRequest req = (NoticeRequest) new NoticeRequest().valueOf(gxunRequest.getData());
		for (Message msg : req.getMsglist()) {
			System.out.println(msg.getNick() + "# >" + msg.getMsg());
		}

		NoticeResponse resp = new NoticeResponse();
		resp.setStatus(200);
		resp.setMessage("send success.");
		rpcResponse(resp);

	}

}
