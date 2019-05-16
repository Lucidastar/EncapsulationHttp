package com.lucidastar.encapsulationhttp.otherhttp.mode;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public class BaseResponse<T> {

    private String sn;
    private boolean success;
    private T entity;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return entity;
    }

    public void setData(T entity) {
        this.entity = entity;
    }
}
