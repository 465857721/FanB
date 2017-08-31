package com.wetime.fanb.frag.iviews;


import com.king.batterytest.fbaselib.main.iview.IBaseVIew;
import com.wetime.fanb.frag.bean.MyPageBean;
import com.wetime.fanb.frag.bean.OrderPageBean;

/**
 * Created by zhoukang on 2017/5/15.
 */

public interface IGetMyPageView extends IBaseVIew {


    void onGetMyResult(MyPageBean bean);

}
