package com.wetime.fanb.act.event;

/**
 * Created by zhoukang on 2017/8/30.
 */

public class ChangeShopEvent {
    private String mid;

    public ChangeShopEvent(String mid) {
        this.mid = mid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
