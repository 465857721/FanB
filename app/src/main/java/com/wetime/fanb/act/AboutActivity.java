package com.wetime.fanb.act;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.king.batterytest.fbaselib.main.BaseActivity;
import com.king.batterytest.fbaselib.utils.Tools;
import com.wetime.fanb.R;
import com.wetime.fanb.frag.bean.UpdateBean;
import com.wetime.fanb.frag.iviews.IGetUpdateView;
import com.wetime.fanb.frag.presenter.GetUpdatePresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends BaseActivity implements IGetUpdateView {


    @Bind(R.id.tv_noupdate)
    TextView tvNoupdate;
    @Bind(R.id.tv_hasupdate)
    TextView tvHasupdate;
    @Bind(R.id.iv_back)
    ImageView ivBack;

    private GetUpdatePresenter getUpdatePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        getUpdatePresenter = new GetUpdatePresenter(this);
        getUpdatePresenter.getOrderResult();
    }


    @Override
    public void onGetMyResult(UpdateBean bean) {
        if (Integer.valueOf(bean.getData().getAppLatestVersion().getVersionCode()) > Tools.getVerCode(this)) {
            tvHasupdate.setVisibility(View.VISIBLE);
            tvNoupdate.setVisibility(View.GONE);

            tvHasupdate.setText("有新版本V" + bean.getData().getAppLatestVersion().getName());
        }

    }

    @OnClick({R.id.iv_back, R.id.tv_hasupdate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.tv_hasupdate:
                Tools.goMarket(this);
                break;
        }
    }
}
