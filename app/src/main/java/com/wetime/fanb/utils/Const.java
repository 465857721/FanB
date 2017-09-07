package com.wetime.fanb.utils;

/**
 * Created by zhoukang on 2017/8/29.
 */

public interface Const {
//    String BASEURL = "http://merchant-test.weishike.net";
    String BASEURL = "https://merchant.weishike.net";
    String LOGIN = BASEURL + "/api/login";
    String ORDERPAGE = BASEURL + "/api/order";
    String SHOPRPAGE = BASEURL + "/api/merchant";
    String MY = BASEURL + "/api/my";
    String MYSOUND = BASEURL + "/api/my/setting";
    String UPDATE = BASEURL + "/api/system/info";
    String PUSH_BIND = BASEURL + "/api/push/bind";
    String LOGOUT = BASEURL + "/api/logout";
}
