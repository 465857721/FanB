package com.wetime.fanb.frag.presenter;


import com.king.batterytest.fbaselib.utils.DataStringCallback;
import com.wetime.fanb.frag.bean.MyPageBean;
import com.wetime.fanb.frag.iviews.IGetMyPageView;
import com.wetime.fanb.utils.Const;
import com.zhy.http.okhttp.OkHttpUtils;

import static com.king.batterytest.fbaselib.utils.GsonUtils.getGsonInstance;


/**
 * Created by zhoukang on 2017/5/15.
 */

public class GetMyPgaePresenter {
    private IGetMyPageView iview;

    public GetMyPgaePresenter(IGetMyPageView iview) {
        this.iview = iview;
    }

    public void getOrderResult() {

        OkHttpUtils
                .post()
                .url(Const.MY)
                .addParams("token", iview.getToken())
                .build()
                .execute(new DataStringCallback(iview, false) {
                    @Override
                    public void onResponse(String s, int i) {
                        super.onResponse(s, i);
                        MyPageBean msg = getGsonInstance().fromJson(s, MyPageBean.class);
                        if (msg.getError() == 0)
                            iview.onGetMyResult(msg);
                    }
                });
    }
}
