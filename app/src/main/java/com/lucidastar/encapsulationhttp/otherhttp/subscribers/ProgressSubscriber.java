package com.lucidastar.encapsulationhttp.otherhttp.subscribers;

import android.os.Looper;
import android.text.TextUtils;

import com.lucidastar.encapsulationhttp.otherhttp.exception.ExceptionHandle;
import com.lucidastar.encapsulationhttp.otherhttp.exception.HttpTimeException;
import com.lucidastar.encapsulationhttp.otherhttp.listener.HttpOnNextListener;
import com.mine.lucidastarutils.log.KLog;
import com.mine.lucidastarutils.utils.NetworkUtils;
import com.mine.lucidastarutils.utils.ToastUtils;


import org.reactivestreams.Subscriber;

import java.net.ConnectException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
//https://github.com/yezizaiqiutian/JiKeTools/blob/3cd6cafbaacf0a7d5c8611048d9b1ba34c689960/retrofittools/src/main/java/com/gh/retrofittools/subscribers/ProgressSubscriber.java

/**
 * Created by qiuyouzone on 2018/5/2.
 */

public class ProgressSubscriber<T>  implements Observer<T>{
    private HttpOnNextListener<T> mSubscriberOnNextListener;
    private Disposable disposable;
    public ProgressSubscriber(HttpOnNextListener<T> subscriberOnNextListener) {
        mSubscriberOnNextListener = subscriberOnNextListener;
    }
    /**
     * 订阅开始时调用
     * 显示ProgressDialog
     */
    @Override
    public void onSubscribe(@NonNull Disposable d) {
        disposable = d;
        //如果没有网络则不进行请求
       if (!NetworkUtils.isConnected()) {
            errorDo(new ConnectException());
           disposable.dispose();
            return;
        }
    }

    @Override
    public void onComplete() {

    }

    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     *
     * @param e
     */
    @Override
    public void onError(final Throwable e) {
        errorDo(e);
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onError(e);
        }
    }

    /*错误统一处理*/
    private void errorDo(Throwable e) {
        ExceptionHandle.ResponeThrowable responeThrowable = ExceptionHandle.handleException(e);
        if (!TextUtils.isEmpty(responeThrowable.message)){//这会把code=500也会打印出来
//                ToastUtils.show(responeThrowable.getMessage());
//            UtilToast.show(responeThrowable.message);
            ToastUtils.showShortToast(responeThrowable.message);
        }
        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onError(responeThrowable.message);
        }

    }
    /**
     * 将onNext方法中的返回结果交给Activity或Fragment自己处理
     *
     * @param t 创建Subscriber时的泛型类型
     */
    @Override
    public void onNext(T t) {
        KLog.i("progressSubscriber", Looper.getMainLooper() == Looper.myLooper());
        KLog.i("progressSubscriber", t);

        if (mSubscriberOnNextListener != null) {
            mSubscriberOnNextListener.onNext(t);
        }
    }
    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    public void onCancelProgress() {
        unSubscribe();
    }

    public void unSubscribe() {
        if (disposable != null && !disposable.isDisposed())
            disposable.dispose();
    }

}