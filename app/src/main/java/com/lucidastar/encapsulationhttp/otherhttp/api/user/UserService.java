package com.lucidastar.encapsulationhttp.otherhttp.api.user;


import com.lucidastar.encapsulationhttp.otherhttp.mode.BaseResponse;
import com.lucidastar.encapsulationhttp.otherhttp.mode.UserModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public interface UserService {
    @GET("?body={\"token\":\"1b33dc128edc44379b5124f13afdcf81\",\"version\":\"406\",\"sn\":1528682805346,\"service\":\"info\",\"method\":\"list\",\"params\":{\"zoneTypeId\":\"\",\"search\":\"\",\"pageSize\":\"10\",\"pageIndex\":\"1\"}}")
    Observable<BaseResponse<UserModel>> getUserInfo();
}
