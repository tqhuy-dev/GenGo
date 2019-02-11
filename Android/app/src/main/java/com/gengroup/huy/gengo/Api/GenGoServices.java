package com.gengroup.huy.gengo.Api;

import com.gengroup.huy.gengo.Api.Body.LoginBody;
import com.gengroup.huy.gengo.Api.Body.SigninBody;
import com.gengroup.huy.gengo.Api.Response.BaseResponse;
import com.gengroup.huy.gengo.Api.Response.FoodStoreListResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by
 * Huy on 2/9/2019.
 */
//http://localhost:3000/api/v1/user/login
public interface GenGoServices {

    @POST("user/login")
    public abstract Call<BaseResponse> login(@Body LoginBody loginBody);

    @POST("user/signin")
    public abstract Call<BaseResponse> signin(@Body SigninBody signinBody);

    @GET("foodStore")
    public abstract Call<FoodStoreListResponse> getListFoodStore();
}
