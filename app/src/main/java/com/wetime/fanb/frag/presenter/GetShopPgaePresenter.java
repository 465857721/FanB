package com.wetime.fanb.frag.presenter;


import com.king.batterytest.fbaselib.utils.Const;
import com.king.batterytest.fbaselib.utils.DataStringCallback;
import com.wetime.fanb.frag.bean.ShopPageBean;
import com.wetime.fanb.frag.iviews.IGetShopPageView;
import com.zhy.http.okhttp.OkHttpUtils;

import static com.king.batterytest.fbaselib.utils.GsonUtils.getGsonInstance;


/**
 * Created by zhoukang on 2017/5/15.
 */

public class GetShopPgaePresenter {
    private IGetShopPageView iview;

    public GetShopPgaePresenter(IGetShopPageView iview) {
        this.iview = iview;
    }

    public void getOrderResult() {

        OkHttpUtils
                .post()
                .url(Const.SHOPRPAGE)
                .addParams("token", iview.getToken())
                .build()
                .execute(new DataStringCallback(iview, false) {
                    @Override
                    public void onResponse(String s, int i) {
                        super.onResponse(s, i);
                        ShopPageBean msg = getGsonInstance().fromJson(s, ShopPageBean.class);
                        if (msg.getError() == 0)
                            iview.onGetShopResult(msg);
                    }
                });
    }
}
