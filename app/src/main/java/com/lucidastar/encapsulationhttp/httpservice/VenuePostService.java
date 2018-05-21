package com.lucidastar.encapsulationhttp.httpservice;

import com.lucidastar.encapsulationhttp.bean.VenueListBean;
import com.lucidastar.encapsulationhttp.nettools.api.BaseResultEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by qiuyouzone on 2018/5/18.
 */

public interface VenuePostService {
    @POST("/app2/request?")
    Observable<BaseResultEntity<VenueListBean>> getVenue(@Body RequestBody body);
}
