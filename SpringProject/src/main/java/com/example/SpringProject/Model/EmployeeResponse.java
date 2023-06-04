package com.example.SpringProject.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EmployeeResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private Object data;
    @JsonProperty("message")
    private String message;

    public EmployeeResponse(String status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public EmployeeResponse(){

    }

    @Override
    public String toString() {
        return "EmployeeResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}