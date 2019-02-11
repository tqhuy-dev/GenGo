package com.gengroup.huy.gengo.View.MainView.FoodFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gengroup.huy.gengo.Adapter.FoodStoreAdapter;
import com.gengroup.huy.gengo.Common.Constant.Constant;
import com.gengroup.huy.gengo.Model.FoodStore;
import com.gengroup.huy.gengo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {

    private RecyclerView rcvListFoodStore;

    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);
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
        FoodStore foodStore = new FoodStore.FoodStoreBuilder("huy","Coffee House")
                .setAddress("Pho Quang")
                .setBooking(145)
                .setStatus(Constant.OPEN_STATUS)
                .setRatePoint(3)
                .build();

        FoodStore foodStore1 = new FoodStore.FoodStoreBuilder("huy","Texas Chicken")
                .setAddress("Phan Xich Long")
                .setBooking(140)
                .setStatus(Constant.CLOSED_STATUS)
                .setRatePoint(4)
                .build();

        List<FoodStore> list= new ArrayList<>();
        list.add(foodStore);
        list.add(foodStore1);
        FoodStoreAdapter adapter = new FoodStoreAdapter(getContext(),list);
        rcvListFoodStore.setAdapter(adapter);
    }

    private void setupRecycleView(){
        this.setRecycleView();
        this.setDataRecycleView();
    }
}
