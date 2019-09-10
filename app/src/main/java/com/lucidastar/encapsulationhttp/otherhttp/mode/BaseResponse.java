package com.lucidastar.encapsulationhttp.otherhttp.mode;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public class BaseResponse<T> {

    private int code;
    private String message;
    private T entity;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return entity;
    }

    public void setData(T entity) {
        this.entity = entity;
    }
}
