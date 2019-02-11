package com.gengroup.huy.gengo.View.MainView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.gengroup.huy.gengo.Common.Constant.Constant;
import com.gengroup.huy.gengo.Common.Enum.DirectionFragment;
import com.gengroup.huy.gengo.Common.Interface.IActivity;
import com.gengroup.huy.gengo.R;
import com.gengroup.huy.gengo.View.MainView.FoodFragment.FoodFragment;
import com.gengroup.huy.gengo.View.MainView.NotificationFragment.NotificationFragment;
import com.gengroup.huy.gengo.View.MainView.StorageFragment.StorageFragment;
import com.gengroup.huy.gengo.View.MainView.TransactionFragment.TransactionFragment;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements IActivity {

    private Toolbar toolbar;
    private TextView tvTitle;
    private BottomNavigationView navigation;
    private FragmentManager manager = getSupportFragmentManager();
    private int oldIndexFragment = 1 ;
    private int newIndexFragment = 1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            tvTitle.setText(item.getTitle().toString());
            SwiftFragment(item);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_notifications:
                    return true;
                case R.id.navigation_storage:
                    return true;
                case R.id.navigation_transaction:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setID();
        setStandardFragment();
        tvTitle.setText(R.string.title_home);
    }

    private void setStandardFragment(){
        FragmentTransaction transaction = manager.beginTransaction();
        FoodFragment foodFragment = new FoodFragment();
        transaction.add(R.id.frameLayout , foodFragment);
        transaction.commit();
    }

    private void SwiftFragment(@NonNull MenuItem menuItem){
        Fragment fragment = null;
        oldIndexFragment = newIndexFragment;
        switch (menuItem.getItemId()){
            case R.id.navigation_home:{
                newIndexFragment = 1;
                fragment = new FoodFragment();
            }break;

            case R.id.navigation_storage:{
                newIndexFragment = 2;
                fragment = new StorageFragment();
            }break;

            case R.id.navigation_notifications:{
                newIndexFragment = 3;
                fragment = new NotificationFragment();
            }break;

            case R.id.navigation_transaction:{
                newIndexFragment = 4;
                fragment = new TransactionFragment();
                break;
            }
        }
        FragmentTransaction transaction = manager.beginTransaction();
        if(newIndexFragment > oldIndexFragment){
            setAnimation(DirectionFragment.RIGHT , transaction);
        }else {
            setAnimation(DirectionFragment.LEFT , transaction);
        }
        transaction.replace(R.id.frameLayout , fragment);
        transaction.commit();
    }

    @Override
    public void setID() {
        toolbar = findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitleToolbar);
    }

    @Override
    public void setEvent() {

    }

    private void setAnimation(DirectionFragment directionFragment , FragmentTransaction transaction){
        if(directionFragment == DirectionFragment.LEFT){
            transaction.setCustomAnimations(R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
        } else if (directionFragment == DirectionFragment.RIGHT) {
            transaction.setCustomAnimations(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left);
        }
    }

}
