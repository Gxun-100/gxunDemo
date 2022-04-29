package com.gxun.chat.service;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.gxun.chat.entity.Message;
import com.gxun.chat.entity.NoticeRequest;
import com.gxun.chat.entity.SendRequest;
import com.gxun.chat.entity.SendResponse;
import com.gxun.core.GxunException;
import com.gxun.core.GxunRequest;
import com.gxun.java.annotation.GxunMethodAnno;
import com.gxun.java.service.GService;

public class CharRoomService extends GService {

	private static int mid = 1;
	private final static List<Message> msgdb = new LinkedList<Message>();
	private final static HashSet<Long> clientSet = new HashSet<Long>();

	@GxunMethodAnno(method = "SEND", protocolId = 30, protocolName = "聊天室", protocolVer = "1.0")
	public void onDataArrive_Send(GxunRequest gxunRequest) {
		try {
			SendRequest req = (SendRequest) new SendRequest().valueOf(gxunRequest.getData());
			String nick = req.getNick();
			String message = req.getMsg();
			System.out.println(nick + "#> " + message);

			long mynetid = gxunRequest.getGnetId();

			Message msg = new Message();
			msg.setId(mid);
			msg.setMsg(message);
			msg.setNick(nick);
			msg.setType(req.getType());
			msg.setTime(new Date().getTime());
			msgdb.add(msg);

			SendResponse resp = new SendResponse();
			resp.setStatus(200);
			resp.setMessage("send success.");
			resp.setId(mid);

			clientSet.add(gxunRequest.getGnetId());

			rpcResponse(resp);

			NoticeRequest nreq = new NoticeRequest();
			nreq.getMsglist().add(msg);
			for (long netid : clientSet) {
				if (mynetid != netid) {
					rpcCall(netid, "NOTICE", nreq, 6000);
				}
			}
			mid++;
		} catch (GxunException e) {
			e.printStackTrace();
		}
	}

}
