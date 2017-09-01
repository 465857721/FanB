package com.wetime.fanb.act;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.king.batterytest.fbaselib.main.BaseActivity;
import com.king.batterytest.fbaselib.utils.SpeechUtils;
import com.wetime.fanb.R;
import com.wetime.fanb.act.bean.LoginResultBean;
import com.wetime.fanb.act.iviews.ILoginView;
import com.wetime.fanb.act.presenter.LoginPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {


    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_psw)
    EditText etPsw;
    @Bind(R.id.tv_login)
    TextView tvLogin;


    private LoginPresenter loginPresenter;

    SpeechUtils speechUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        speechUtils = SpeechUtils.getsSpeechUtils(this);
        loginPresenter = new LoginPresenter(this);

        etPhone.setText(spu.getValue("phone"));
    }

    @OnClick(R.id.tv_login)
    public void onViewClicked() {
//        speechUtils.speak("饭团收银到账100.34元");

        loginPresenter.getLoginResult();
        spu.setValue("phone", etPhone.getText().toString());


    }

    @Override
    public String getName() {
        return etPhone.getText().toString();
    }

    @Override
    public String getPsw() {
        return etPsw.getText().toString();
    }

    @Override
    public void onCheckResult(LoginResultBean bean) {
        if (bean.getError() == 0) {
            spu.setToken(bean.getData().getToken());
            spu.setValue("first",bean.getData().getIsNeedChangePwd());
            spu.setValue("changepswurl",bean.getData().getHrefModifyPwd());
            Intent gomain = new Intent(mContext, MainActivity.class);
            startActivity(gomain);
            finish();
        }
    }
}
