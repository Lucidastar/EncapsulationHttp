package com.lucidastar.encapsulationhttp.httpservice;

import com.lucidastar.encapsulationhttp.bean.VenueListBean;
import com.lucidastar.encapsulationhttp.nettools.api.BaseResultEntity;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by qiuyouzone on 2018/5/18.
 */

public interface VenuePostService {
    @GET("/app2/request?body={\"token\":\"39faf3f377694697bb465af0da648683\",\"version\":\"406\",\"sn\":1526610125013,\"service\":\"statium\",\"method\":\"search\",\"params\":{\"sportType\":\"\",\"size\":\"1\",\"city\":\"北京市\",\"begin\":\"0\",\"type\":\"list\",\"lat\":\"39.915215\",\"lng\":\"116.403954\"}}")
    Observable<BaseResultEntity<VenueListBean>> getVenue(@Body RequestBody body);
}
