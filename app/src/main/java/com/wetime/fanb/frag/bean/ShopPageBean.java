package com.wetime.fanb.frag.bean;

import java.util.List;

/**
 * Created by zhoukang on 2017/8/30.
 */

public class ShopPageBean {

    /**
     * data : {"merchants":[{"mid":"37","name":"靖哥收钱吧便利店","hrefInfo":"http://merchant-test.weishike.net/merchant/info?mid=37&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","hrefCode":"http://merchant-test.weishike.net/merchant/qrcode?mid=37&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","hrefUser":"http://merchant-test.weishike.net/user/user_list?mid=37&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","role":"1"},{"mid":"1","name":"靖哥便利店","hrefInfo":"http://merchant-test.weishike.net/merchant/info?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","hrefCode":"http://merchant-test.weishike.net/merchant/qrcode?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","hrefUser":"http://merchant-test.weishike.net/user/user_list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","role":"1"}],"bannerImg":"https://pay.weishike.net/image/img/banner.jpg"}
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
         * merchants : [{"mid":"37","name":"靖哥收钱吧便利店","hrefInfo":"http://merchant-test.weishike.net/merchant/info?mid=37&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","hrefCode":"http://merchant-test.weishike.net/merchant/qrcode?mid=37&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","hrefUser":"http://merchant-test.weishike.net/user/user_list?mid=37&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","role":"1"},{"mid":"1","name":"靖哥便利店","hrefInfo":"http://merchant-test.weishike.net/merchant/info?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","hrefCode":"http://merchant-test.weishike.net/merchant/qrcode?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","hrefUser":"http://merchant-test.weishike.net/user/user_list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz","role":"1"}]
         * bannerImg : https://pay.weishike.net/image/img/banner.jpg
         */

        private String bannerImg;
        private List<MerchantsBean> merchants;

        public String getBannerImg() {
            return bannerImg;
        }

        public void setBannerImg(String bannerImg) {
            this.bannerImg = bannerImg;
        }

        public List<MerchantsBean> getMerchants() {
            return merchants;
        }

        public void setMerchants(List<MerchantsBean> merchants) {
            this.merchants = merchants;
        }

        public static class MerchantsBean {
            /**
             * mid : 37
             * name : 靖哥收钱吧便利店
             * hrefInfo : http://merchant-test.weishike.net/merchant/info?mid=37&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz
             * hrefCode : http://merchant-test.weishike.net/merchant/qrcode?mid=37&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz
             * hrefUser : http://merchant-test.weishike.net/user/user_list?mid=37&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz
             * role : 1
             */

            private String mid;
            private String name;
            private String hrefInfo;
            private String hrefCode;
            private String hrefUser;
            private String role;
            private String  imageCode;

            public String getImageCode() {
                return imageCode;
            }

            public void setImageCode(String imageCode) {
                this.imageCode = imageCode;
            }

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHrefInfo() {
                return hrefInfo;
            }

            public void setHrefInfo(String hrefInfo) {
                this.hrefInfo = hrefInfo;
            }

            public String getHrefCode() {
                return hrefCode;
            }

            public void setHrefCode(String hrefCode) {
                this.hrefCode = hrefCode;
            }

            public String getHrefUser() {
                return hrefUser;
            }

            public void setHrefUser(String hrefUser) {
                this.hrefUser = hrefUser;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }
    }
}
