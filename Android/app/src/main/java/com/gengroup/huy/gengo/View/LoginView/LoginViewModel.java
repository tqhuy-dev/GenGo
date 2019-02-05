package com.gengroup.huy.gengo.View.LoginView;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.gengroup.huy.gengo.Model.User;

/**
 * Created by
 * Huy on 2/4/2019.
 */

class LoginViewModel extends ViewModel {
    private MutableLiveData<User> user = new MutableLiveData<>();

    public LiveData<User> getUser() {
        if(user == null){
            user = new MutableLiveData<>();
        }
        return user;
    }
}
