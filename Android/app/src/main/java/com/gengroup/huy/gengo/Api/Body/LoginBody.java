package com.gengroup.huy.gengo.Api.Body;

/**
 * Created by
 * Huy on 2/9/2019.
 */

public class LoginBody {
    private String account;
    private String password;

    public LoginBody(String account, String password) {

        this.account = account;
        this.password = password;

    }
}
