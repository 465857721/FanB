package com.wetime.fanb.frag.presenter;


import com.king.batterytest.fbaselib.main.model.BaseBean;
import com.king.batterytest.fbaselib.utils.DataStringCallback;
import com.wetime.fanb.frag.bean.MyPageBean;
import com.wetime.fanb.frag.iviews.IGetMyPageView;
import com.wetime.fanb.frag.iviews.ISetSoundView;
import com.wetime.fanb.utils.Const;
import com.zhy.http.okhttp.OkHttpUtils;

import static com.king.batterytest.fbaselib.utils.GsonUtils.getGsonInstance;


/**
 * Created by zhoukang on 2017/5/15.
 */

public class SetSoundPresenter {
    private ISetSoundView iview;

    public SetSoundPresenter(ISetSoundView iview) {
        this.iview = iview;
    }

    public void getSetResult(String sound_enabled) {

        OkHttpUtils
                .post()
                .url(Const.MYSOUND)
                .addParams("token", iview.getToken())
                .addParams("sound_enabled", sound_enabled)
                .build()
                .execute(new DataStringCallback(iview, false) {
                    @Override
                    public void onResponse(String s, int i) {
                        super.onResponse(s, i);
                        BaseBean msg = getGsonInstance().fromJson(s, BaseBean.class);
                        if (msg.getError() == 0)
                            iview.onSetSoundResult(msg);
                    }
                });
    }
}
