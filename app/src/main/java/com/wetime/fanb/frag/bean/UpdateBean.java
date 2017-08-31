package com.wetime.fanb.frag.bean;

/**
 * Created by zhoukang on 2017/8/31.
 */

public class UpdateBean {

    /**
     * data : {"appLatestVersion":{"versionCode":"100","name":"1.0.0"},"h5LoginUrl":"http://merchant-test.weishike.net/site/login"}
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
         * appLatestVersion : {"versionCode":"100","name":"1.0.0"}
         * h5LoginUrl : http://merchant-test.weishike.net/site/login
         */

        private AppLatestVersionBean appLatestVersion;
        private String h5LoginUrl;

        public AppLatestVersionBean getAppLatestVersion() {
            return appLatestVersion;
        }

        public void setAppLatestVersion(AppLatestVersionBean appLatestVersion) {
            this.appLatestVersion = appLatestVersion;
        }

        public String getH5LoginUrl() {
            return h5LoginUrl;
        }

        public void setH5LoginUrl(String h5LoginUrl) {
            this.h5LoginUrl = h5LoginUrl;
        }

        public static class AppLatestVersionBean {
            /**
             * versionCode : 100
             * name : 1.0.0
             */

            private String versionCode;
            private String name;

            public String getVersionCode() {
                return versionCode;
            }

            public void setVersionCode(String versionCode) {
                this.versionCode = versionCode;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
