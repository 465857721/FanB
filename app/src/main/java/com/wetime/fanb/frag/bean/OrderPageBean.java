package com.wetime.fanb.frag.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhoukang on 2017/8/30.
 */

public class OrderPageBean implements Serializable {

    /**
     * data : {"today":{"count":"0","cashSum":"0","href":"http://merchant-test.weishike.net/order/list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz"},"last3month":[{"dt":"2017年08月","amount":"0.2","href":"http://merchant-test.weishike.net/order/list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz&sdate=2017-08-01&edate=2017-08-30"},{"dt":"2017年07月","amount":"0","href":"http://merchant-test.weishike.net/order/list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz&sdate=2017-07-01&edate=2017-07-31"},{"dt":"2017年06月","amount":"0","href":"http://merchant-test.weishike.net/order/list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz&sdate=2017-06-01&edate=2017-06-30"}],"merchant":{"mid":"1","name":"靖哥便利店"},"merchants":[{"mid":"1","name":"靖哥便利店"},{"mid":"37","name":"靖哥收钱吧便利店"}]}
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

    public static class DataBean implements Serializable {
        /**
         * today : {"count":"0","cashSum":"0","href":"http://merchant-test.weishike.net/order/list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz"}
         * last3month : [{"dt":"2017年08月","amount":"0.2","href":"http://merchant-test.weishike.net/order/list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz&sdate=2017-08-01&edate=2017-08-30"},{"dt":"2017年07月","amount":"0","href":"http://merchant-test.weishike.net/order/list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz&sdate=2017-07-01&edate=2017-07-31"},{"dt":"2017年06月","amount":"0","href":"http://merchant-test.weishike.net/order/list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz&sdate=2017-06-01&edate=2017-06-30"}]
         * merchant : {"mid":"1","name":"靖哥便利店"}
         * merchants : [{"mid":"1","name":"靖哥便利店"},{"mid":"37","name":"靖哥收钱吧便利店"}]
         */

        private TodayBean today;
        private MerchantBean merchant;
        private List<Last3monthBean> last3month;
        private List<MerchantsBean> merchants;

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }

        public MerchantBean getMerchant() {
            return merchant;
        }

        public void setMerchant(MerchantBean merchant) {
            this.merchant = merchant;
        }

        public List<Last3monthBean> getLast3month() {
            return last3month;
        }

        public void setLast3month(List<Last3monthBean> last3month) {
            this.last3month = last3month;
        }

        public List<MerchantsBean> getMerchants() {
            return merchants;
        }

        public void setMerchants(List<MerchantsBean> merchants) {
            this.merchants = merchants;
        }

        public static class TodayBean implements Serializable {
            /**
             * count : 0
             * cashSum : 0
             * href : http://merchant-test.weishike.net/order/list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz
             */

            private String count;
            private String cashSum;
            private String href;

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public String getCashSum() {
                return cashSum;
            }

            public void setCashSum(String cashSum) {
                this.cashSum = cashSum;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class MerchantBean implements Serializable {
            /**
             * mid : 1
             * name : 靖哥便利店
             */

            private String mid;
            private String name;

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
        }

        public static class Last3monthBean implements Serializable {
            /**
             * dt : 2017年08月
             * amount : 0.2
             * href : http://merchant-test.weishike.net/order/list?mid=1&token=Gbo4f7fswZHK50m3d3zcw8t2MAehWAZz&sdate=2017-08-01&edate=2017-08-30
             */

            private String dt;
            private String amount;
            private String href;

            public String getDt() {
                return dt;
            }

            public void setDt(String dt) {
                this.dt = dt;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        public static class MerchantsBean implements Serializable {
            /**
             * mid : 1
             * name : 靖哥便利店
             */

            private String mid;
            private String name;

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
        }
    }
}
