package com.gxun.message;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunny
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new Vo(new Date())));
        Vo vo = JSONObject.parseObject("{\"time\":1651212787561}", Vo.class);
        System.out.println(vo.getTime().getTime());
    }
    private static class Vo{
        private Date time;

        public Vo() {
        }

        public Vo(Date time) {
            this.time = time;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }
    }
}
