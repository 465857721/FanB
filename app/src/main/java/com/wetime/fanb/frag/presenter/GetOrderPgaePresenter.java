package com.wetime.fanb.frag.presenter;


import com.king.batterytest.fbaselib.utils.Const;
import com.king.batterytest.fbaselib.utils.DataStringCallback;
import com.wetime.fanb.act.bean.LoginResultBean;
import com.wetime.fanb.act.iviews.ILoginView;
import com.wetime.fanb.frag.bean.OrderPageBean;
import com.wetime.fanb.frag.iviews.IGetOrderPageView;
import com.zhy.http.okhttp.OkHttpUtils;

import static com.king.batterytest.fbaselib.utils.GsonUtils.getGsonInstance;


/**
 * Created by zhoukang on 2017/5/15.
 */

public class GetOrderPgaePresenter {
    private IGetOrderPageView iview;

    public GetOrderPgaePresenter(IGetOrderPageView iview) {
        this.iview = iview;
    }

    public void getOrderResult() {

        OkHttpUtils
                .post()
                .url(Const.ORDERPAGE)
                .addParams("token", iview.getToken())
                .addParams("mid", iview.getMid())
                .build()
                .execute(new DataStringCallback(iview, false) {
                    @Override
                    public void onResponse(String s, int i) {
                        super.onResponse(s, i);

                        OrderPageBean msg = getGsonInstance().fromJson(s, OrderPageBean.class);
                        if (msg.getError() == 0)
                            iview.onGetOrderResult(msg);
                    }
                });
    }
}
