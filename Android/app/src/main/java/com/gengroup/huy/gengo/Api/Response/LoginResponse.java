package com.gengroup.huy.gengo.Api.Response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by
 * Huy on 2/9/2019.
 */

public class LoginResponse {

    @SerializedName("statusCode")
    public Integer statusCode;

    @SerializedName("message")
    public String message;
}
