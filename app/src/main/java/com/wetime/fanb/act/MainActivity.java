package com.wetime.fanb.act;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.king.batterytest.fbaselib.main.BaseActivity;
import com.king.batterytest.fbaselib.view.CustomViewPager;
import com.wetime.fanb.R;
import com.wetime.fanb.frag.HomeFragmentPagerAdapter;
import com.wetime.fanb.frag.MyFragment;
import com.wetime.fanb.frag.OrderFragment;
import com.wetime.fanb.frag.ShopFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @Bind(R.id.vp)
    CustomViewPager vp;
    @Bind(R.id.navigation)
    BottomNavigationView navigation;

    private List<Fragment> list_fragment = new ArrayList<>();


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    vp.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    vp.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    vp.setCurrentItem(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initView();
    }

    private void initView() {
        OrderFragment f1 = new OrderFragment();
        ShopFragment f2 = new ShopFragment();
        MyFragment f3 = new MyFragment();
        list_fragment.add(f1);
        list_fragment.add(f2);
        list_fragment.add(f3);

        vp.setAdapter(new HomeFragmentPagerAdapter(getSupportFragmentManager(), list_fragment));

        vp.setCurrentItem(0);
        vp.setOffscreenPageLimit(2);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().getItem(0).setChecked(true);
        vp.setScanScroll(false);
    }
}
