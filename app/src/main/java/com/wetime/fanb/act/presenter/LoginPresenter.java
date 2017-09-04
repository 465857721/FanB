package com.wetime.fanb.act.presenter;


import com.king.batterytest.fbaselib.utils.Const;
import com.king.batterytest.fbaselib.utils.DataStringCallback;
import com.wetime.fanb.act.bean.LoginResultBean;
import com.wetime.fanb.act.iviews.ILoginView;
import com.zhy.http.okhttp.OkHttpUtils;

import static com.king.batterytest.fbaselib.utils.GsonUtils.getGsonInstance;


/**
 * Created by zhoukang on 2017/5/15.
 */

public class LoginPresenter {
    private ILoginView iview;

    public LoginPresenter(ILoginView iview) {
        this.iview = iview;
    }

    public void getLoginResult() {

        OkHttpUtils
                .post()
                .url(Const.LOGIN)
                .addParams("phone", iview.getName())
                .addParams("password", iview.getPsw())
                .build()
                .execute(new DataStringCallback(iview) {
                    @Override
                    public void onResponse(String s, int i) {
                        super.onResponse(s, i);

                        LoginResultBean msg = getGsonInstance().fromJson(s, LoginResultBean.class);
                        if (msg.getError() == 0)
                            iview.onCheckResult(msg);
                    }
                });
    }
}
