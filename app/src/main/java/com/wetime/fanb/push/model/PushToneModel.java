package com.wetime.fanb.push.model;

/**
 * Created by zhoukang on 2017/5/15.
 */

public class PushToneModel {


    /**
     * money : 0.01
     * sound_enabled : 1
     */

    private String money;
    private String sound_enabled;
    private String push_id;

    public String getPush_id() {
        return push_id;
    }

    public void setPush_id(String push_id) {
        this.push_id = push_id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSound_enabled() {
        return sound_enabled;
    }

    public void setSound_enabled(String sound_enabled) {
        this.sound_enabled = sound_enabled;
    }
}
