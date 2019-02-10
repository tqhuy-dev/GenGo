package com.gengroup.huy.gengo.Api.Body;

/**
 * Created by
 * Huy on 2/10/2019.
 */

public class SigninBody extends LoginBody {
    public SigninBody(String account, String password , String firstName , String lastName) {
        super(account, password);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String firstName = "" ;
    private String lastName = "";

}
