package com.wetime.fanb.act.iviews;


import com.king.batterytest.fbaselib.main.iview.IBaseVIew;
import com.wetime.fanb.act.bean.LoginResultBean;

/**
 * Created by zhoukang on 2017/5/15.
 */

public interface ILoginView extends IBaseVIew {

    String getName();
    String getPsw();
    void onCheckResult(LoginResultBean bean);

}
