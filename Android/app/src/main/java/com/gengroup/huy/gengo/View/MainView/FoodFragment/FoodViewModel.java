package com.gengroup.huy.gengo.View.MainView.FoodFragment;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.gengroup.huy.gengo.Model.FoodStore;

import java.util.List;

/**
 * Created by
 * Huy on 2/10/2019.
 */

public class FoodViewModel extends ViewModel {
    private MutableLiveData<List<FoodStore>> listStore = new MutableLiveData<>();

}
