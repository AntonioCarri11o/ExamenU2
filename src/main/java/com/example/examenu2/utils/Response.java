package com.example.examenu2.utils;

public class Response <T>{
    Integer status;
    String message;
    T data;
    boolean error;
    public Response() {
    }

    public Response(Integer status, String message, T data,boolean error) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
