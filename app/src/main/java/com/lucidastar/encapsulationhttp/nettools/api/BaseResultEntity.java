package com.lucidastar.encapsulationhttp.nettools.api;

/**
 * Created by qiuyouzone on 2018/4/28.
 */

public class BaseResultEntity<T> {
    private int code;
    private String msg;
    private boolean success;
    private String sn;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public T getEntity() {
        return data;
    }

    public void setEntity(T entity) {
        this.data = entity;
    }
}
