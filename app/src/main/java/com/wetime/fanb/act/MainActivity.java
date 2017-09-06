package com.wetime.fanb.act;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.king.batterytest.fbaselib.main.BaseActivity;
import com.king.batterytest.fbaselib.view.CustomViewPager;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGPushServiceV3;
import com.wetime.fanb.R;
import com.wetime.fanb.act.event.ReFreshMyEvent;
import com.wetime.fanb.act.event.ReFreshOrderEvent;
import com.wetime.fanb.act.iviews.IBindPushView;
import com.wetime.fanb.act.presenter.BindPushPresenter;
import com.wetime.fanb.frag.HomeFragmentPagerAdapter;
import com.wetime.fanb.frag.MyFragment;
import com.wetime.fanb.frag.OrderFragment;
import com.wetime.fanb.frag.ShopFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements IBindPushView {
    @Bind(R.id.vp)
    CustomViewPager vp;
    @Bind(R.id.content)
    FrameLayout content;
    @Bind(R.id.iv_tab1)
    ImageView ivTab1;
    @Bind(R.id.tv_tab1)
    TextView tvTab1;
    @Bind(R.id.ll_tab1)
    LinearLayout llTab1;
    @Bind(R.id.iv_tab2)
    ImageView ivTab2;
    @Bind(R.id.tv_tab2)
    TextView tvTab2;
    @Bind(R.id.ll_tab2)
    LinearLayout llTab2;
    @Bind(R.id.iv_tab3)
    ImageView ivTab3;
    @Bind(R.id.tv_tab3)
    TextView tvTab3;
    @Bind(R.id.ll_tab3)
    LinearLayout llTab3;
    @Bind(R.id.container)
    LinearLayout container;


    private List<Fragment> list_fragment = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initXG();
        initView();
        if (spu.getValue("first").equals("1")) {
            showDialog(spu.getValue("changepswurl"));
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

        vp.setScanScroll(false);
    }

    private void initXG() {
//        XGPushConfig.enableDebug(this, true);
        // 如果需要知道注册是否成功，请使用registerPush(getApplicationContext(), XGIOperateCallback)带callback版本
        // 如果需要绑定账号，请使用registerPush(getApplicationContext(),account)版本
        // 具体可参考详细的开发指南
        // 传递的参数为ApplicationContext
        Context context = getApplicationContext();
        XGPushManager.registerPush(context, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object o, int i) {
                Handler mHandler = new Handler();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        BindPushPresenter pushPresenter = new BindPushPresenter(MainActivity.this);
                        pushPresenter.bindPush(XGPushConfig.getToken(MainActivity.this));
                    }
                });

            }

            @Override
            public void onFail(Object o, int i, String s) {
                Log.d("TPush", "xg fail s = " + s);
                Log.d("TPush", "xg fail i = " + i);
            }
        });

        Intent service = new Intent(context, XGPushServiceV3.class);
        context.startService(service);
    }

    @OnClick({R.id.ll_tab1, R.id.ll_tab2, R.id.ll_tab3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_tab1:
                if (vp.getCurrentItem() != 0) {
                    initBottom(0);
                    vp.setCurrentItem(0);
                    EventBus.getDefault().post(new ReFreshOrderEvent());
                }
                break;
            case R.id.ll_tab2:
                if (vp.getCurrentItem() != 1) {
                    vp.setCurrentItem(1);
                    initBottom(1);
                }
                break;
            case R.id.ll_tab3:
                if (vp.getCurrentItem() != 2) {
                    vp.setCurrentItem(2);
                    initBottom(2);
                    EventBus.getDefault().post(new ReFreshMyEvent());
                }
                break;
        }
    }

    private void initBottom(int item) {
        if (item == 0) {
            ivTab1.setImageResource(R.drawable.bot_1_on);
            ivTab2.setImageResource(R.drawable.bot_2_off);
            ivTab3.setImageResource(R.drawable.bot_3_off);

            tvTab1.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
            tvTab2.setTextColor(ContextCompat.getColor(this, R.color.bot_gray));
            tvTab3.setTextColor(ContextCompat.getColor(this, R.color.bot_gray));
        }
        if (item == 1) {
            ivTab1.setImageResource(R.drawable.bot_1_off);
            ivTab2.setImageResource(R.drawable.bot_2_on);
            ivTab3.setImageResource(R.drawable.bot_3_off);

            tvTab1.setTextColor(ContextCompat.getColor(this, R.color.bot_gray));
            tvTab2.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
            tvTab3.setTextColor(ContextCompat.getColor(this, R.color.bot_gray));
        }
        if (item == 2) {
            ivTab1.setImageResource(R.drawable.bot_1_off);
            ivTab2.setImageResource(R.drawable.bot_2_off);
            ivTab3.setImageResource(R.drawable.bot_3_on);

            tvTab1.setTextColor(ContextCompat.getColor(this, R.color.bot_gray));
            tvTab2.setTextColor(ContextCompat.getColor(this, R.color.bot_gray));
            tvTab3.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }

    }
}
