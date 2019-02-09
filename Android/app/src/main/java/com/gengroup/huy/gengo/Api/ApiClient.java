package com.gengroup.huy.gengo.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by
 * Huy on 2/9/2019.
 */

public class ApiClient {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://10.0.3.2:3000/api/v1/";

    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit;
    }
}
