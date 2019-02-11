package com.gengroup.huy.gengo.Api.Response;

import com.gengroup.huy.gengo.Model.BaseModel;
import com.gengroup.huy.gengo.Model.FoodStore;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by
 * Huy on 2/11/2019.
 */

public class FoodStoreListResponse extends BaseResponse{

    @SerializedName("data")
    public List<FoodStore> data;

}
