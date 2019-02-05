package com.gengroup.huy.gengo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gengroup.huy.gengo.Model.User;
import com.gengroup.huy.gengo.R;

import java.util.List;

/**
 * Created by DELL on 2/5/2019.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> friends;
    private Context context;

    public UserAdapter(Context context, List<User> friend){
        this.context = context;
        this.friends = friend;
    }

    @Override
    public int getItemCount() {
        return this.friends == null ? 0 : this.friends.size();
    }

    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_friend, parent , false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.tvName.setText(friends.get(position).getAccount());
        holder.tvPoint.setText(String.valueOf(friends.get(position).getPoint()));
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName , tvPoint;
        public UserViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvPoint = itemView.findViewById(R.id.tvPoint);
        }
    }
}
