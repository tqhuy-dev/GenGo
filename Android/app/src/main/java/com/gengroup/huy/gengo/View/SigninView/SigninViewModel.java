package com.gengroup.huy.gengo.View.SigninView;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.gengroup.huy.gengo.Model.User;

/**
 * Created by
 * Huy on 2/6/2019.
 */

public class SigninViewModel extends ViewModel {
    MutableLiveData<User> user = new MutableLiveData<>();

    public LiveData<User> getUser() {
        if(user == null) {
            user = new MutableLiveData<>();
        }
        return  user;
    }
}
