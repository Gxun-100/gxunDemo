package com.gxun.message.isp.entity;

import com.gxun.java.response.GResponse;

/**
 * @author sunny
 */
public class DemoIspResponse extends GResponse {

    String status;

    String message;

    public DemoIspResponse() {
    }

    public DemoIspResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
