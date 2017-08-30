package com.wetime.fanb.frag.iviews;


import com.king.batterytest.fbaselib.main.iview.IBaseVIew;
import com.wetime.fanb.act.bean.LoginResultBean;
import com.wetime.fanb.frag.bean.OrderPageBean;

/**
 * Created by zhoukang on 2017/5/15.
 */

public interface IGetOrderPageView extends IBaseVIew {

    String getMid();
    void onGetOrderResult(OrderPageBean bean);

}
