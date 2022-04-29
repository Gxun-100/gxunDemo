package com.gxun.chat;

import java.util.Scanner;

import com.gxun.chat.entity.SendRequest;
import com.gxun.chat.service.CharClientService;
import com.gxun.core.GxunApi;
import com.gxun.java.node.DefaultNode;
import com.gxun.java.node.GxunNodeHelper;

public class ClientMain {
	public static int LOCAL_SID = 0;
	public static int LOCAL_GNET = 0;

	public static void main(String[] args) throws Exception {
		//GxunApi.setEnableLog(true);
		System.out.println("==欢迎您进入极迅聊天室==");
		System.out.println("您的SID是：" + args[0]);
		System.out.println("您的GNET是：" + args[1]);
		LOCAL_SID = Integer.valueOf(args[0]);
		LOCAL_GNET = Integer.valueOf(args[1]);
		
		DefaultNode node = GxunNodeHelper.startDefaultNode(1000037, LOCAL_SID, "pri.key", "gxunyunke", 0);
		CharClientService service = new CharClientService();
		node.registerService(service);

		Scanner reader = new Scanner(System.in);
		System.out.print("请输入您的昵称:");
		String nick = reader.nextLine();

		while (true) {
			reader.nextLine();// <---勉强读取一个回车符号
			System.out.print(nick + "# >");
			String msg = reader.nextLine();

			SendRequest req = new SendRequest();
			req.setType("TEXT");
			req.setNick(nick);
			req.setMsg(msg);

			service.rpcCall(LOCAL_GNET, "SEND", req, 10000);

		}
	}
}
