package com.wetime.fanb.frag.iviews;


import com.king.batterytest.fbaselib.main.iview.IBaseVIew;
import com.wetime.fanb.frag.bean.OrderPageBean;
import com.wetime.fanb.frag.bean.ShopPageBean;

/**
 * Created by zhoukang on 2017/5/15.
 */

public interface IGetShopPageView extends IBaseVIew {


    void onGetShopResult(ShopPageBean bean);

}
