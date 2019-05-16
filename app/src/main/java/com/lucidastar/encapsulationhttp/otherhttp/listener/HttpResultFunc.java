package com.lucidastar.encapsulationhttp.otherhttp.listener;

import android.os.Looper;

import com.lucidastar.encapsulationhttp.otherhttp.exception.ExceptionHandle;
import com.lucidastar.encapsulationhttp.otherhttp.mode.BaseResponse;
import com.mine.lucidastarutils.log.KLog;


import io.reactivex.functions.Function;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public class HttpResultFunc<T> implements Function<BaseResponse<T>, T> {
    @Override
    public T apply(BaseResponse<T> httpResult) throws Exception {//数据统一处理
        KLog.i("httpResult", Looper.getMainLooper() == Looper.myLooper());
        if (!httpResult.isSuccess()) {//获取数据失败
            throw new ExceptionHandle.ServerException("");
        }
        return httpResult.getData();
    }
}
