package com.lucidastar.encapsulationhttp.otherhttp;

import android.util.Log;

import com.lucidastar.encapsulationhttp.otherhttp.base.Constants;
import com.mine.lucidastarutils.log.KLog;
import com.mine.lucidastarutils.log.KLogUtil;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public class HttpManager {
    public static HttpManager INSTANCE;

    private HttpManager() {
        createRetrofit();
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
    public Retrofit mRetrofit;

    /**
     * 生成接口实现类的实例
     */
    public <T> T createService(Class<T> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

    private Retrofit createRetrofit() {
        return mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                // 设置OkHttpclient
                .client(initOkhttpClient())
                // RxJava2
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                // Gson
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient initOkhttpClient() {
        OkHttpClient  okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(getHttpLoggingInterceptor())//设置日志打印
                .retryOnConnectionFailure(true)//失败重连
                .connectTimeout(30, TimeUnit.SECONDS)//网络请求超时时间单位为秒
                .build();
        return okHttpClient;
    }

    /**
     * 日志输出
     * 自行判定是否添加
     * @return
     */
    private HttpLoggingInterceptor getHttpLoggingInterceptor(){
        //日志显示级别
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
//                KLog.i("result=="+message);
            }
        });
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }
}
