package com.gxun.message.filter.entity;

import com.gxun.java.request.GRequest;

/**
 * @author sunny
 */
public class DemoFilterRequest extends GRequest {
    private String token;
    private String customerid;
    private String type;
    private String mobile;
    private String content;
    private String taskid;

    public DemoFilterRequest() {
    }

    public DemoFilterRequest(String token, String customerid, String type, String mobile, String content, String taskid) {
        this.token = token;
        this.customerid = customerid;
        this.type = type;
        this.mobile = mobile;
        this.content = content;
        this.taskid = taskid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }
}
