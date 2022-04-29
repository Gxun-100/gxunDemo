package com.gxun.chat;

import java.io.IOException;

import com.gxun.chat.node.ChatRoomNode;
import com.gxun.chat.service.CharRoomService;
import com.gxun.core.GxunApi;
import com.gxun.java.node.DefaultNode;
import com.gxun.java.node.GxunNodeHelper;

public class RoomMain {

	public static void main(String[] args) throws InterruptedException, IOException {
		//GxunApi.setEnableLog(true);
		DefaultNode node = GxunNodeHelper.startAnnotationNode(ChatRoomNode.class);
		CharRoomService service = new CharRoomService();
		node.registerService(service);
	}
}
