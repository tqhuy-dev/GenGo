package com.gengroup.huy.gengo.Api;

import com.gengroup.huy.gengo.Api.Body.LoginBody;
import com.gengroup.huy.gengo.Api.Response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by
 * Huy on 2/9/2019.
 */
//http://localhost:3000/api/v1/user/login
public interface GenGoServices {

    @POST("user/login")
    public abstract Call<LoginResponse> login(@Body LoginBody loginBody);
}
