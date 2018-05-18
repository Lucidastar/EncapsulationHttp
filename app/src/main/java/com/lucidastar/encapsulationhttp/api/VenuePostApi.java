package com.lucidastar.encapsulationhttp.api;

import com.lucidastar.encapsulationhttp.bean.VenueListBean;
import com.lucidastar.encapsulationhttp.httpservice.VenuePostService;
import com.lucidastar.encapsulationhttp.nettools.api.BaseApi;
import com.lucidastar.encapsulationhttp.nettools.listener.HttpOnNextListener;
import com.lucidastar.encapsulationhttp.utils.ParamsUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.lang.ref.PhantomReference;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

/**
 * Created by qiuyouzone on 2018/5/18.
 */

public class VenuePostApi extends BaseApi<VenueListBean> {

    private String mService;
    private String mMethod;
    private Map<String,String> mParams;

    public VenuePostApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity, String service, String method, Map<String, String> params) {
        super(listener, rxAppCompatActivity);
        mService = service;
        mMethod = method;
        mParams = params;
    }

    public VenuePostApi(HttpOnNextListener<VenueListBean> listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener, rxAppCompatActivity);
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        VenuePostService venuePostService = retrofit.create(VenuePostService.class);
        return venuePostService.getVenue(getRequestBody());
    }

    private RequestBody getRequestBody(){
        return ParamsUtils.getRequestBody(mService, mMethod, mParams, isContainToken());
    }
}
