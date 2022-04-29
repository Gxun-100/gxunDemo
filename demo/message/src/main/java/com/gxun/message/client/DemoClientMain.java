package com.gxun.message.client;

import com.alibaba.fastjson.JSONObject;
import com.gxun.core.GxunApi;
import com.gxun.core.GxunException;
import com.gxun.java.node.DefaultNode;
import com.gxun.java.node.GxunNodeHelper;
import com.gxun.java.service.GService;
import com.gxun.message.client.entity.DemoClientRequest;
import com.gxun.message.client.node.DemoClientNode;
import com.gxun.message.client.service.DemoClientService;

import java.util.Scanner;
import java.util.UUID;

/**
 * @author sunny
 */
public class DemoClientMain {

    public static void main(String[] args) throws GxunException {
        GxunApi.setEnableLog(false);
        DefaultNode node = GxunNodeHelper.startProfileNode();
        GService service = new DemoClientService();
        node.registerService(service);
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input your mobile No. or press exit to exit,press enter to confirm");
        String s = scanner.nextLine();
        while (!"exit".equals(s)) {
            String mobile = s;
            System.out.println("your mobile No. is:" + mobile);
            System.out.println("please input your message ,press enter to confirm");
            String message = scanner.nextLine();
            System.out.println("your message is:" + message);
            try{
                JSONObject gResponse = service.rpcCall(44, "FILTER", new DemoClientRequest("abcde", "1000002:2001", "YZM", mobile, message, UUID.randomUUID().toString()));
                System.out.println(gResponse.toJSONString());
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("please input your mobile No. or press exit to exit,press enter to confirm");
            s = scanner.nextLine();
        }
    }
}
