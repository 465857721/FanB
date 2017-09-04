package com.wetime.fanb.frag.presenter;


import com.king.batterytest.fbaselib.utils.Const;
import com.king.batterytest.fbaselib.utils.DataStringCallback;
import com.wetime.fanb.frag.bean.MyPageBean;
import com.wetime.fanb.frag.bean.UpdateBean;
import com.wetime.fanb.frag.iviews.IGetMyPageView;
import com.wetime.fanb.frag.iviews.IGetUpdateView;
import com.zhy.http.okhttp.OkHttpUtils;

import static com.king.batterytest.fbaselib.utils.GsonUtils.getGsonInstance;


/**
 * Created by zhoukang on 2017/5/15.
 */

public class GetUpdatePresenter {
    private IGetUpdateView iview;

    public GetUpdatePresenter(IGetUpdateView iview) {
        this.iview = iview;
    }

    public void getOrderResult() {

        OkHttpUtils
                .post()
                .url(Const.UPDATE)
                .build()
                .execute(new DataStringCallback(iview, false) {
                    @Override
                    public void onResponse(String s, int i) {
                        super.onResponse(s, i);
                        UpdateBean msg = getGsonInstance().fromJson(s, UpdateBean.class);
                        if (msg.getError() == 0)
                            iview.onGetMyResult(msg);
                    }
                });
    }
}
