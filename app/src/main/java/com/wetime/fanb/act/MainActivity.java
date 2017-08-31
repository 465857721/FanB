package com.wetime.fanb.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

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
        if (getIntent() != null && getIntent().getStringExtra("show") != null && getIntent().getStringExtra("show").equals("0")) {
            showDialog(getIntent().getStringExtra("url"));
        }
    }

    private void showDialog(final String url) {
        LayoutInflater inflaterDl = LayoutInflater.from(mContext);
        LinearLayout layout = (LinearLayout) inflaterDl.inflate(
                R.layout.dialog_gochangepsw, null);
        final AlertDialog tel_dialog = new AlertDialog.Builder(mContext).create();
        tel_dialog.setCancelable(false);
        tel_dialog.setCanceledOnTouchOutside(false);
        tel_dialog.show();
        tel_dialog.getWindow().setContentView(layout);


        Button btnOK = (Button) layout.findViewById(R.id.dialog_btn_ok);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goWeb(url);

            }
        });

    }

    private void goWeb(String url) {
        Intent goweb = new Intent(this, WebActivity.class);
        goweb.putExtra("url", url);
        startActivity(goweb);


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
