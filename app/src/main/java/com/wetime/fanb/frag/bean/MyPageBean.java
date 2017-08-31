package com.wetime.fanb.frag.bean;

/**
 * Created by zhoukang on 2017/8/31.
 */

public class MyPageBean {

    /**
     * data : {"username":"刘静","merchantCount":"2","phone":"13246719084","rate":"0.1%","acceptNotify":"0","hrefModifyPwd":"http://merchant-test.weishike.net/user/update_password_form?token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","role":"1"}
     * msg :
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
         * username : 刘静
         * merchantCount : 2
         * phone : 13246719084
         * rate : 0.1%
         * acceptNotify : 0
         * hrefModifyPwd : http://merchant-test.weishike.net/user/update_password_form?token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz
         * role : 1
         */

        private String username;
        private String merchantCount;
        private String phone;
        private String rate;
        private String acceptNotify;
        private String hrefModifyPwd;
        private String role;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMerchantCount() {
            return merchantCount;
        }

        public void setMerchantCount(String merchantCount) {
            this.merchantCount = merchantCount;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getAcceptNotify() {
            return acceptNotify;
        }

        public void setAcceptNotify(String acceptNotify) {
            this.acceptNotify = acceptNotify;
        }

        public String getHrefModifyPwd() {
            return hrefModifyPwd;
        }

        public void setHrefModifyPwd(String hrefModifyPwd) {
            this.hrefModifyPwd = hrefModifyPwd;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
