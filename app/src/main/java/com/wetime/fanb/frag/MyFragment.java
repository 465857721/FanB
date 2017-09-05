package com.wetime.fanb.frag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.king.batterytest.fbaselib.main.BaseFragment;
import com.king.batterytest.fbaselib.main.model.BaseBean;
import com.king.batterytest.fbaselib.utils.Tools;
import com.wetime.fanb.R;
import com.wetime.fanb.act.AboutActivity;
import com.wetime.fanb.act.LoginActivity;
import com.wetime.fanb.act.WebActivity;
import com.wetime.fanb.frag.bean.MyPageBean;
import com.wetime.fanb.frag.iviews.IGetMyPageView;
import com.wetime.fanb.frag.iviews.ILogoutView;
import com.wetime.fanb.frag.iviews.ISetSoundView;
import com.wetime.fanb.frag.presenter.GetMyPgaePresenter;
import com.wetime.fanb.frag.presenter.LogoutPresenter;
import com.wetime.fanb.frag.presenter.SetSoundPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MyFragment extends BaseFragment implements IGetMyPageView, ILogoutView, ISetSoundView {

    @Bind(R.id.tv_userhead)
    TextView tvUserhead;
    @Bind(R.id.tv_username)
    TextView tvUsername;
    @Bind(R.id.tv_shopnum)
    TextView tvShopnum;
    @Bind(R.id.tv_phonenum)
    TextView tvPhonenum;
    @Bind(R.id.ll_phone)
    LinearLayout llPhone;
    @Bind(R.id.tv_changepsw)
    TextView tvChangepsw;
    @Bind(R.id.sw_voice)
    Switch swVoice;
    @Bind(R.id.tv_cardstate)
    TextView tvCardstate;
    @Bind(R.id.ll_card)
    LinearLayout llCard;
    @Bind(R.id.tv_daotime)
    TextView tvDaotime;
    @Bind(R.id.ll_daozhang)
    LinearLayout llDaozhang;
    @Bind(R.id.tv_rate)
    TextView tvRate;
    @Bind(R.id.ll_rate)
    LinearLayout llRate;
    @Bind(R.id.tv_aboutus)
    TextView tvAboutus;

    private GetMyPgaePresenter getMyPgaePresenter;
    private MyPageBean bean;
    private SetSoundPresenter setSoundPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_my, null);
        ButterKnife.bind(this, v);
        getMyPgaePresenter = new GetMyPgaePresenter(this);
        getMyPgaePresenter.getOrderResult();
        setSoundPresenter = new SetSoundPresenter(this);
        return v;
    }


    @Override
    public void onGetMyResult(MyPageBean bean) {

        this.bean = bean;
        if (bean.getData().getRole().equals("1")) {
            tvUserhead.setText("老板");
        } else {
            tvUserhead.setText("员工");
        }

        tvPhonenum.setText(bean.getData().getPhone());
        if (bean.getData().getSound_enabled().equals("0")) {
            swVoice.setChecked(false);
        } else {
            swVoice.setChecked(true);
        }
        swVoice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    setSoundPresenter.getSetResult("1");
                } else {
                    setSoundPresenter.getSetResult("0");
                }
            }
        });
        tvRate.setText(bean.getData().getRate());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.tv_changepsw, R.id.tv_aboutus, R.id.tv_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_changepsw:
                goWeb(bean.getData().getHrefModifyPwd());
                break;
            case R.id.tv_aboutus:
                Intent goAbout = new Intent(getActivity(), AboutActivity.class);
                getActivity().startActivity(goAbout);
                break;
            case R.id.tv_logout:
                LogoutPresenter logoutPresenter = new LogoutPresenter(this);
                logoutPresenter.getLogoutResult();
                break;
        }
    }

    private void goWeb(String url) {
        Intent goweb = new Intent(getActivity(), WebActivity.class);
        goweb.putExtra("url", url);
        getActivity().startActivity(goweb);


    }

    @Override
    public String getPushToken() {
        return null;
    }

    @Override
    public void onLogoutResult(BaseBean bean) {
        Tools.logout(getActivity());
        getActivity().finish();
        Intent login = new Intent(getActivity(), LoginActivity.class);
        startActivity(login);
    }

    @Override
    public void onSetSoundResult(BaseBean bean) {

    }
}
