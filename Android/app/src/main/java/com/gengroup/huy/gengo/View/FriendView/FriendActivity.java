package com.gengroup.huy.gengo.View.FriendView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gengroup.huy.gengo.Adapter.UserAdapter;
import com.gengroup.huy.gengo.Model.User;
import com.gengroup.huy.gengo.R;

import java.util.ArrayList;
import java.util.List;

public class FriendActivity extends AppCompatActivity {

    RecyclerView rcvFriend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        rcvFriend = findViewById(R.id.rcvFriend);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvFriend.setLayoutManager(layoutManager);
        rcvFriend.setHasFixedSize(true);
        User user1 = new User.UserBuilder("tqhuy1996","0946515847")
                .setPoint(10)
                .build();
        User user2 = new User.UserBuilder("namnguyen1997","123")
                .setPoint(10)
                .build();
        List<User> friendList = new ArrayList<>();
        friendList.add(user1);
        friendList.add(user2);
        UserAdapter adapter = new UserAdapter(FriendActivity.this,friendList);
        rcvFriend.setAdapter(adapter);
    }
}
