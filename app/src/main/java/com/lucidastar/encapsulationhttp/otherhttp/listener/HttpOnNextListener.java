package com.lucidastar.encapsulationhttp.otherhttp.listener;

import io.reactivex.Observable;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public abstract class HttpOnNextListener<T> {

    /**
     * 成功后回调方法
     *t
     * @param
     */
    public abstract void onNext(T t);

    /**
     * 失败或者错误方法
     * 主动调用，更加灵活
     *
     * @param e
     */
    public void onError(Throwable e) {

    }

    /**
     * 失败或者错误方法
     * 主动调用，更加灵活
     *
     * @param message
     */
    public void onError(String message) {

    }

    /**
     * 取消回調
     */
    public void onCancel() {

    }
}
