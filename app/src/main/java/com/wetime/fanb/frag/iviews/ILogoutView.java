package com.wetime.fanb.frag.iviews;


import com.king.batterytest.fbaselib.main.iview.IBaseVIew;
import com.king.batterytest.fbaselib.main.model.BaseBean;
import com.wetime.fanb.frag.bean.UpdateBean;

/**
 * Created by zhoukang on 2017/5/15.
 */

public interface ILogoutView extends IBaseVIew {

    String getPushToken();
    void onLogoutResult(BaseBean bean);

}
