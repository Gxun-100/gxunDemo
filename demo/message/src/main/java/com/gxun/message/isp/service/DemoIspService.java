package com.gxun.message.isp.service;

import com.gxun.core.GxunException;
import com.gxun.core.GxunRequest;
import com.gxun.java.annotation.GxunMethodAnno;
import com.gxun.java.service.GService;
import com.gxun.message.isp.entity.DemoIspCallBack;
import com.gxun.message.isp.entity.DemoIspCallBackResponse;
import com.gxun.message.isp.entity.DemoIspRequest;
import com.gxun.message.isp.entity.DemoIspResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunny
 */
public class DemoIspService extends GService {

    @GxunMethodAnno(method = "SEND", protocolId = 44, protocolVer = "1.0", protocolName = "前海百递短信demo标准")
    public void onDataArriveSend(GxunRequest gxunRequest) {
        System.out.println(gxunRequest.getData());
        try {
            DemoIspRequest ispRequestVo = (DemoIspRequest) new DemoIspRequest().valueOf(gxunRequest.getData());
            String message = ispRequestVo.getContent();
            System.out.println("发送短信：" + message);
            rpcResponse(new DemoIspResponse("200", "success"));
            //模拟回调
            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List<DemoIspCallBack.Task> ls = new ArrayList<>();
                DemoIspCallBack.Task task = new DemoIspCallBack.Task("200", ispRequestVo.getTaskid(),"发送成功");
                ls.add(task);
                DemoIspCallBackResponse callback = null;
                try {
                    callback = rpcCall(gxunRequest.getGnetId(), "CALLBACK", new DemoIspCallBack(ls), DemoIspCallBackResponse.class);
                    System.out.println(callback.getStatus());
                } catch (GxunException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (GxunException e) {
            e.printStackTrace();
        }
    }
}
