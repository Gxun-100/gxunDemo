package com.gxun.message.isp.entity;

import com.gxun.java.request.GRequest;

import java.util.List;

/**
 * @author sunny
 */
public class DemoIspCallBack extends GRequest {


    private List<Task> tasks;

    public DemoIspCallBack(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public static class Task {
        private String status;
        private String taskid;
        private String message;

        public Task(String status, String taskid, String message) {
            this.status = status;
            this.taskid = taskid;
            this.message = message;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTaskid() {
            return taskid;
        }

        public void setTaskid(String taskid) {
            this.taskid = taskid;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
