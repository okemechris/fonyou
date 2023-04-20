package com.product.demo.pojo;


public class APIResponse<T> {


    private final String message;
    private final boolean success;
    private T payload;

    public APIResponse(T payload){
        this.message = "Request successful";
        this.success = true;
        this.payload = payload;
    }


    public APIResponse(String message, boolean success){
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getPayload() {
        return payload;
    }
}