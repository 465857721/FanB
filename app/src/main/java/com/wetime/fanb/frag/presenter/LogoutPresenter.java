package com.wetime.fanb.frag.presenter;


import com.king.batterytest.fbaselib.main.model.BaseBean;
import com.king.batterytest.fbaselib.utils.Const;
import com.king.batterytest.fbaselib.utils.DataStringCallback;
import com.wetime.fanb.frag.iviews.ILogoutView;
import com.zhy.http.okhttp.OkHttpUtils;

import static com.king.batterytest.fbaselib.utils.GsonUtils.getGsonInstance;


/**
 * Created by zhoukang on 2017/5/15.
 */

public class LogoutPresenter {
    private ILogoutView iview;

    public LogoutPresenter(ILogoutView iview) {
        this.iview = iview;
    }

    public void getLogoutResult() {

        OkHttpUtils
                .post()
                .url(Const.LOGOUT)
                .addParams("token", iview.getToken())
                .addParams("push_token", iview.getToken())
                .build()
                .execute(new DataStringCallback(iview) {
                    @Override
                    public void onResponse(String s, int i) {
                        super.onResponse(s, i);
                        BaseBean msg = getGsonInstance().fromJson(s, BaseBean.class);
                        iview.onLogoutResult(msg);
                    }
                });
    }
}
