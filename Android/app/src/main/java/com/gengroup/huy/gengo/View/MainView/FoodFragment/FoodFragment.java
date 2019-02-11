package com.gengroup.huy.gengo.View.MainView.FoodFragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gengroup.huy.gengo.Adapter.FoodStoreAdapter;
import com.gengroup.huy.gengo.Api.ApiClient;
import com.gengroup.huy.gengo.Api.GenGoServices;
import com.gengroup.huy.gengo.Api.Response.FoodStoreListResponse;
import com.gengroup.huy.gengo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    private RecyclerView rcvListFoodStore;
    GenGoServices genGoServices;

    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        genGoServices= ApiClient.getClient().create(GenGoServices.class);
        setID(view);
        setupRecycleView();
        return view;
    }

    private void setID(View itemView){
        rcvListFoodStore = itemView.findViewById(R.id.rcvFoodStoreList);
    }

    private void setRecycleView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcvListFoodStore.setLayoutManager(layoutManager);
        rcvListFoodStore.setHasFixedSize(true);
    }

    private void setDataRecycleView(){
        Call<FoodStoreListResponse> call = genGoServices.getListFoodStore();
        call.enqueue(new Callback<FoodStoreListResponse>() {
            @Override
            public void onResponse(@NonNull Call<FoodStoreListResponse> call, @NonNull Response<FoodStoreListResponse> response) {
                Log.d("Data",String.valueOf(response.body().data.size()));
                FoodStoreAdapter adapter = new FoodStoreAdapter(getContext(),response.body().data);
                rcvListFoodStore.setAdapter(adapter);
            }

            @Override
            public void onFailure(@NonNull Call<FoodStoreListResponse> call, @NonNull Throwable t) {

            }
        });
    }

    private void setupRecycleView(){
        this.setRecycleView();
        this.setDataRecycleView();
    }
}
