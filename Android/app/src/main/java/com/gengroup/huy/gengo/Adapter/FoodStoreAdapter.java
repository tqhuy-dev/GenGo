package com.gengroup.huy.gengo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gengroup.huy.gengo.Common.Constant.ColorConstant;
import com.gengroup.huy.gengo.Common.Constant.Constant;
import com.gengroup.huy.gengo.Common.Helper.TransformValue;
import com.gengroup.huy.gengo.Model.FoodStore;
import com.gengroup.huy.gengo.R;



import java.util.List;

/**
 * Created by
 * Huy on 2/10/2019.
 */

public class FoodStoreAdapter extends RecyclerView.Adapter<FoodStoreAdapter.FoodStoreViewHolder> {
    private List<FoodStore> foodStoreList;
    private Context context;

    public FoodStoreAdapter(Context context , List<FoodStore> foodStores){
        this.context = context;
        this.foodStoreList = foodStores;
    }

    @Override
    public FoodStoreAdapter.FoodStoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_food_store,parent,false);
        return new FoodStoreViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FoodStoreAdapter.FoodStoreViewHolder holder, int position) {
        TransformValue transformValue = new TransformValue();
        holder.tvNameStore.setText(foodStoreList.get(position).getStoreName());
        holder.tvBooking.setText(String.valueOf(foodStoreList.get(position).getBooking()));
        holder.tvAddressStore.setText(foodStoreList.get(position).getAddress());
        holder.tvRatePoint.setText(String.valueOf(foodStoreList.get(position).getRatePoint()));
        holder.tvStatus.setText(transformValue.TransformStatus(foodStoreList.get(position).getStatus()));
        onLayout(holder);
    }

    private void onLayout(FoodStoreAdapter.FoodStoreViewHolder holder){
        if(Integer.parseInt(holder.tvRatePoint.getText().toString()) > Constant.POINT_CHECK){
            holder.tvRatePoint.setTextColor(ColorConstant.COLOR_GOOD_POINT);
        }else {
            holder.tvRatePoint.setTextColor(ColorConstant.COLOR_WEAK_POINT);
        }

        if(holder.tvStatus.getText().toString().equals(TransformValue.StatusValue.OPEN)){
            holder.tvStatus.setBackgroundColor(ColorConstant.COLOR_OPEN_STATUS);
        } else {
            holder.tvStatus.setBackgroundColor(ColorConstant.COLOR_OPEN_STATUS);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return this.foodStoreList == null? 0 : this.foodStoreList.size();
    }

    public static class FoodStoreViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNameStore ;
        private TextView tvAddressStore;
        private TextView tvStatus;
        private TextView tvBooking;
        private TextView tvRatePoint;

        public FoodStoreViewHolder(View itemView) {
            super(itemView);
            tvNameStore = itemView.findViewById(R.id.tvNameStore);
            tvAddressStore = itemView.findViewById(R.id.tvAddressStore);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvBooking = itemView.findViewById(R.id.tvBooking);
            tvRatePoint = itemView.findViewById(R.id.tvRatePoint);
        }
    }
}
