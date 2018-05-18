package com.lucidastar.encapsulationhttp.api;

import com.lucidastar.encapsulationhttp.bean.VenueListBean;
import com.lucidastar.encapsulationhttp.httpservice.VenuePostService;
import com.lucidastar.encapsulationhttp.nettools.api.BaseApi;
import com.lucidastar.encapsulationhttp.nettools.listener.HttpOnNextListener;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by qiuyouzone on 2018/5/18.
 */

public class VenuePostApi extends BaseApi<VenueListBean> {
    public VenuePostApi(HttpOnNextListener<VenueListBean> listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener, rxAppCompatActivity);
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        VenuePostService venuePostService = retrofit.create(VenuePostService.class);
        return venuePostService.getVenue();
    }


}
