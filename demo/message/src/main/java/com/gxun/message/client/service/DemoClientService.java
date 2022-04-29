package com.gxun.message.client.service;

import com.alibaba.fastjson.JSONObject;
import com.gxun.core.GxunException;
import com.gxun.core.GxunRequest;
import com.gxun.java.annotation.GxunMethodAnno;
import com.gxun.java.service.GService;
import com.gxun.message.client.entity.DemoClientCallBack;
import com.gxun.message.client.entity.DemoClientResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunny
 */
public class DemoClientService extends GService {

    @GxunMethodAnno(method = "CALLBACK", protocolId = 44, protocolVer = "1.0", protocolName = "前海百递短信demo标准")
    public void onDataArrive(GxunRequest gxunRequest) {
        System.out.println(gxunRequest.getData());
        try {
            DemoClientCallBack callback = JSONObject.parseObject(gxunRequest.getData(), DemoClientCallBack.class);
            rpcResponse(new DemoClientResponse("200", "success"));
        } catch (GxunException e) {
            e.printStackTrace();
        }
    }
}
