package com.wetime.fanb.act;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.king.batterytest.fbaselib.main.BaseActivity;
import com.wetime.fanb.R;
import com.wetime.fanb.act.presenter.LoginPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChoiceShopActivity extends BaseActivity {


    @Bind(R.id.tv_cancel)
    TextView tvCancel;
    @Bind(R.id.rl_choiceshop)
    RelativeLayout rlChoiceshop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choiceshop);
        ButterKnife.bind(this);


    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(0, 0);
    }

    @OnClick({R.id.tv_cancel, R.id.rl_choiceshop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                onBackPressed();
                break;
            case R.id.rl_choiceshop:
                break;
        }
    }
}
