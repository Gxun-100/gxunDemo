package com.gxun.message.filter.service;

import com.gxun.core.GxunException;
import com.gxun.core.GxunRequest;
import com.gxun.java.annotation.GxunMethodAnno;
import com.gxun.java.service.GService;
import com.gxun.message.filter.entity.DemoFilterRequest;
import com.gxun.message.filter.entity.DemoFilterResponse;
import com.gxun.message.isp.entity.DemoIspResponse;

/**
 * @author sunny
 */
public class DemoFilterService extends GService {

    @GxunMethodAnno(method = "FILTER", protocolId = 44, protocolVer = "1.0", protocolName = "前海百递短信demo标准")
    public void onDataArrive_Filter(GxunRequest gxunRequest) {
        System.out.println(gxunRequest.getData());
        try {
            DemoFilterRequest filterRequestVo = (DemoFilterRequest) new DemoFilterRequest().valueOf(gxunRequest.getData());
            String message = filterRequestVo.getContent();
            if (message.contains("微信")) {
                rpcResponse(new DemoIspResponse("500", "短信不合法"));
                return;
            }
            DemoFilterResponse send = rpcCall(gxunRequest.getGnetId(), "SEND", filterRequestVo, DemoFilterResponse.class);
            rpcResponse(new DemoIspResponse(send.getStatus(), send.getMessage()));
        } catch (GxunException e) {
            e.printStackTrace();
        }
    }
}
