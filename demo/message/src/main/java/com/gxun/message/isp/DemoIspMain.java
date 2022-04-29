package com.gxun.message.isp;

import com.gxun.core.GxunApi;
import com.gxun.core.GxunException;
import com.gxun.java.node.DefaultNode;
import com.gxun.java.node.GxunNodeHelper;
import com.gxun.java.service.GService;
import com.gxun.message.isp.node.DemoIspNode;
import com.gxun.message.isp.service.DemoIspService;

/**
 * @author sunny
 */
public class DemoIspMain {

    public static void main(String[] args) throws GxunException {
        GxunApi.setEnableLog(false);
        DefaultNode node = GxunNodeHelper.startAnnotationNode(DemoIspNode.class);
        GService service = new DemoIspService();
        node.registerService(service);
    }
}
