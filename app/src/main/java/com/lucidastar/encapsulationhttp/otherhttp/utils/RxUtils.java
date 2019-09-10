package com.lucidastar.encapsulationhttp.otherhttp.utils;


import android.support.annotation.NonNull;


import com.lucidastar.encapsulationhttp.view.ILoadingView;
import com.lucidastar.encapsulationhttp.otherhttp.exception.ExceptionHandle;
import com.lucidastar.encapsulationhttp.otherhttp.mode.BaseResponse;

import org.reactivestreams.Publisher;

import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public class RxUtils {

    /**
     * @param <T> 泛型
     * @return 返回Observable
     */
    public static <T> ObservableTransformer<T, T> switchSchedulers() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(@NonNull Disposable disposable) throws Exception {

                            }
                        })
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> ObservableTransformer<BaseResponse<T>, T> handleResult() {
        return new ObservableTransformer<BaseResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResponse<T>> upstream) {
                return upstream.onErrorResumeNext(new ErrorResumeFunction<T>()).flatMap(new ResponseFunction<T>())
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(@NonNull Disposable disposable) throws Exception {

                            }
                        })
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };


    }

    /**
     * 非服务器产生的异常，比如本地无无网络请求，Json数据解析错误等等。
     *
     * @param <T>
     */
    private static class ErrorResumeFunction<T> implements Function<Throwable, ObservableSource<? extends BaseResponse<T>>> {

        @Override
        public ObservableSource<? extends BaseResponse<T>> apply(Throwable throwable) throws Exception {
            return Observable.error(ExceptionHandle.handleException(throwable));
        }
    }

    /**
     * 服务其返回的数据解析
     * 正常服务器返回数据和服务器可能返回的exception
     *
     * @param <T>
     */
    private static class ResponseFunction<T> implements Function<BaseResponse<T>, ObservableSource<T>> {

        @Override
        public ObservableSource<T> apply(BaseResponse<T> tResponse) throws Exception {
            int code = tResponse.getCode();
            String message = tResponse.getMessage();
            //200解析结果    500弹出msg还需要拿到数据有可能是对象 有可能是字符串    401到登录
            if (code == 200) {
                if (tResponse.getData() != null) {
                    return Observable.just(tResponse.getData());
                }
                return Observable.empty();
            } else if (code == 500) {//需要把T转化成具体的类型，然后发出去 也按错误处理
                T data = tResponse.getData();//要是一个对象  然后也需要发出去
                if (data instanceof String){
                    return Observable.error(new ExceptionHandle.ServerException(code, message,data));
                }
                return Observable.error(new ExceptionHandle.ServerException(code, message));
            } else {//里头也会包含401
                return Observable.error(new ExceptionHandle.ServerException(code, message));
            }
        }
    }

    public  static  <T> FlowableTransformer waitLoadingTransformerUsing(final ILoadingView iLoadingView) {
        return new FlowableTransformer<T, T>() {
            @Override public Publisher<T> apply(final Flowable<T> upstream) {
                return Flowable.using(new Callable<ILoadingView>() {
                    @Override public ILoadingView call() throws Exception {
                        //初始化
                        iLoadingView.showDialog();
                        return iLoadingView;
                    }
                }, new Function<ILoadingView, Publisher<? extends T>>() {
                    @Override public Publisher<? extends T> apply(ILoadingView iLoadingView)
                            throws Exception {
                        return upstream;
                    }
                }, new Consumer<ILoadingView>() {
                    @Override public void accept(ILoadingView iLoadingView) throws Exception {
                        //释放资源
                        iLoadingView.dismiss();
                    }
                });
            }
        };
    }
}
