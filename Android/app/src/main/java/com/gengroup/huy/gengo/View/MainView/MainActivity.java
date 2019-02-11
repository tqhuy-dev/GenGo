package com.gengroup.huy.gengo.View.MainView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.gengroup.huy.gengo.Common.Constant.Constant;
import com.gengroup.huy.gengo.Common.Interface.IActivity;
import com.gengroup.huy.gengo.R;
import com.gengroup.huy.gengo.View.MainView.FoodFragment.FoodFragment;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements IActivity {

    Toolbar toolbar;
    TextView tvTitle;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            tvTitle.setText(item.getTitle().toString());
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

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setID();
        setStandardFragment();
        tvTitle.setText(R.string.title_home);
    }

    private void setStandardFragment(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        FoodFragment foodFragment = new FoodFragment();
        transaction.add(R.id.frameLayout , foodFragment);
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

}
