package com.lucidastar.encapsulationhttp.otherhttp;

import com.lucidastar.encapsulationhttp.otherhttp.base.Constants;
import com.mine.lucidastarutils.log.KLog;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public class HttpManager1 {
    public static HttpManager1 INSTANCE;

    private HttpManager1() {
        createRetrofit();
    }

    public static synchronized HttpManager1 getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpManager1.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpManager1();
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
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(getHttpLoggingInterceptor())//设置日志打印
                .addInterceptor(addUrlParams)
                .retryOnConnectionFailure(true)//失败重连
                .connectTimeout(30, TimeUnit.SECONDS)//网络请求超时时间单位为秒
                .build();
        return okHttpClient;
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
                KLog.i("result=="+message);
            }
        });
        loggingInterceptor.setLevel(level);
        return loggingInterceptor;
    }

    private Interceptor addUrlParams = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
            Request request = chain.request();
            HttpUrl oldUrl = request.url();
//            HttpUrl build1 = oldUrl.newBuilder().host(oldUrl.url() + "?token=a3215e41deaf4b46a73f9510b289e68e").build();
            HttpUrl build1=  oldUrl.newBuilder()
                    .scheme(oldUrl.scheme())
                    .host(oldUrl.host())
                    .port(oldUrl.port())
                    .addEncodedQueryParameter("token","a3215e41deaf4b46a73f9510b289e68e")
                    .build();


            return chain.proceed(builder.url(build1).build());
        }
    };
}
