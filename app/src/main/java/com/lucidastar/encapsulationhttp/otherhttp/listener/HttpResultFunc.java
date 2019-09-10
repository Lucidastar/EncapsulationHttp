package com.lucidastar.encapsulationhttp.otherhttp.listener;

import android.os.Looper;

import com.lucidastar.encapsulationhttp.otherhttp.exception.ExceptionHandle;
import com.lucidastar.encapsulationhttp.otherhttp.mode.BaseResponse;
import com.mine.lucidastarutils.log.KLog;


import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public class HttpResultFunc<T> implements Function<BaseResponse<T>, T> {
    @Override
    public T apply(BaseResponse<T> httpResult) throws Exception {//数据统一处理
        KLog.i("httpResult", Looper.getMainLooper() == Looper.myLooper());
        int code = httpResult.getCode();
        String message = httpResult.getMessage();
        //200解析结果    500弹出msg还需要拿到数据有可能是对象 有可能是字符串    401到登录
        if (code == 200) {
            if (httpResult.getData() != null) {
                return httpResult.getData();
            }
            return null;
        } else if (code == 500) {//需要把T转化成具体的类型，然后发出去 也按错误处理
            T data = httpResult.getData();//要是一个对象  然后也需要发出去
            return null;
        }else {
            return null;
        }
    }
}
