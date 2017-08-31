package com.wetime.fanb.act.bean;

/**
 * Created by zhoukang on 2017/8/29.
 */

public class LoginResultBean {


    /**
     * data : {"token":"Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","isNeedChangePwd":"0","hrefModifyPwd":"http://merchant-test.weishike.net/user/update_password_form?token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz"}
     * msg : 登录成功
     * error : 0
     */

    private DataBean data;
    private String msg;
    private int error;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public static class DataBean {
        /**
         * token : Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz
         * isNeedChangePwd : 0
         * hrefModifyPwd : http://merchant-test.weishike.net/user/update_password_form?token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz
         */

        private String token;
        private String isNeedChangePwd;
        private String hrefModifyPwd;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getIsNeedChangePwd() {
            return isNeedChangePwd;
        }

        public void setIsNeedChangePwd(String isNeedChangePwd) {
            this.isNeedChangePwd = isNeedChangePwd;
        }

        public String getHrefModifyPwd() {
            return hrefModifyPwd;
        }

        public void setHrefModifyPwd(String hrefModifyPwd) {
            this.hrefModifyPwd = hrefModifyPwd;
        }
    }
}
