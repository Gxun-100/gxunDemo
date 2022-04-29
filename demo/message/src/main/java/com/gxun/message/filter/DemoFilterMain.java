package com.gxun.message.filter;

import com.gxun.core.GxunApi;
import com.gxun.core.GxunException;
import com.gxun.java.node.DefaultNode;
import com.gxun.java.node.GxunNodeHelper;
import com.gxun.java.response.GResponse;
import com.gxun.java.service.GService;
import com.gxun.message.filter.entity.DemoFilterRequest;
import com.gxun.message.filter.node.DemoFilterNode;
import com.gxun.message.filter.service.DemoFilterService;

/**
 * @author sunny
 */
public class DemoFilterMain {
    public static void main(String[] args) throws GxunException, InterruptedException {
        GxunApi.setEnableLog(false);
        DefaultNode node = GxunNodeHelper.startDefaultNode(1000002, 2002, "pri.key", "gxunyunke", 0);
        GService service = new DemoFilterService();
        node.registerService(service);
//        while(true){
//            Thread.sleep(5000);
//            try {
//                service.rpcCall(44, "SEND", new DemoFilterRequest("abcde","1000002:2001","YZM","12431243","sdfghsdfhsdfh", "11111111"), GResponse.class);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }

    }
}
