package com.lucidastar.encapsulationhttp.nettools.http;

import android.util.Log;


import com.lucidastar.encapsulationhttp.nettools.api.BaseApi;
import com.lucidastar.encapsulationhttp.nettools.exception.RetryWhenNetworkException;
import com.lucidastar.encapsulationhttp.nettools.listener.HttpOnNextListener;
import com.lucidastar.encapsulationhttp.nettools.subscribers.ProgressSubscriber;
import com.trello.rxlifecycle2.android.ActivityEvent;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by qiuyouzone on 2018/4/28.
 */

public class HttpManager {
    public static HttpManager INSTANCE;

    private HttpManager() {
    }

    public static synchronized HttpManager getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpManager();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 处理http请求
     *
     * @param basePar 封装的请求数据
     */
    public void doHttpDeal(BaseApi basePar) {
        //手动创建一个OkHttpClient并设置超时时间缓存等设置
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(basePar.getConnectionTime(), TimeUnit.SECONDS);
//        builder.addInterceptor(new CookieInterceptor(basePar.isCache(), basePar.getUrl()));
        if (Constant.isDebug()) {
            builder.addInterceptor(getHttpLoggingInterceptor());
        }


        /*创建retrofit对象*/
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//Retrofit与rxjava的结合
                .baseUrl(basePar.getBaseUrl())
                .build();


        /*rx处理*/
        ProgressSubscriber progressSubscriber = new ProgressSubscriber(basePar);
        Observable observable = basePar.getObservable(retrofit)
                 /*失败后的retry配置*/
                .retryWhen(new RetryWhenNetworkException(basePar.getRetryCount(),
                        basePar.getRetryDelay(), basePar.getRetryIncreaseDelay()))
                /*生命周期管理*/
                .compose(basePar.getRxAppCompatActivity().bindToLifecycle())
                .compose(basePar.getRxAppCompatActivity().bindUntilEvent(ActivityEvent.PAUSE))
                /*http请求线程*/
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                /*回调线程*/
                .observeOn(AndroidSchedulers.mainThread())
                /*结果判断*/
                .map(basePar);

        /*链接式对象返回*/
        SoftReference<HttpOnNextListener> httpOnNextListener = basePar.getListener();
        if (httpOnNextListener != null && httpOnNextListener.get() != null) {
            httpOnNextListener.get().onNext(observable);
        }
        /*数据回调*/
       observable.subscribe(progressSubscriber);
    }


    /**
     * 日志输出
     * 自行判定是否添加
     *
     * @return
     */
    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        //日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("RxRetrofit", "Retrofit====Message:" + message);
            }
        });
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }
}
