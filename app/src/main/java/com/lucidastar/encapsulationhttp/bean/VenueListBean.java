package com.lucidastar.encapsulationhttp.bean;

import java.util.List;
import java.util.Map;

/**
 * Created by 孙松茂 on 2017/11/15.
 */

public  class VenueListBean {


    /**
     * statiumBean : {"pageSize":10,"pageNo":1,"totalCount":105,"totalPage":11,"data":[{"dist":6.179330644348899,"id":"38bfb0bebcfa490e93463b13882c98b3","city":"北京市市辖区","sport_type":"篮球","name":"华腾园室外篮球场 ","address":"朝阳区东三环南路54号院","phone":"13020000280","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/822bbff01ec344d58bda4f5dfb5acdcd","geo":"39.893279,116.470514","isRating":"0","grade":8,"orderTotal":8,"sportList":[{"BASKETBALL":{"statiumPrice":150,"qiuyouPrice":135}}]},{"dist":10.42455821677228,"id":"b86106eeb1cf44dab346bec3839d6269","city":"北京市市辖区","sport_type":"篮球,网球","name":"北京艾锐斯体育（篮球，网球）","address":"北京市北京市海淀区学院路18号","phone":"18610873888","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/9ef62a2ab4f348d884efec69cc5ef01f","geo":"40.004357,116.366079","isRating":"0","grade":10,"orderTotal":59,"sportList":[{"BASKETBALL":{"statiumPrice":150,"qiuyouPrice":142}}]},{"dist":16.492934697864214,"id":"e5d857cbbddc425da06a20168e7605fb","city":"北京市市辖区","sport_type":"篮球,羽毛球","name":"优肯智能篮球馆（天秀）","address":"北京市海淀区龙背村路","phone":"010-57163936","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/2583549bade34c28b8c5204882e60221","geo":"40.027807,116.277961","isRating":"0","grade":9,"orderTotal":11,"sportList":[{"BADMINTON":{"statiumPrice":40,"qiuyouPrice":36}}]},{"dist":18.751556868295964,"id":"15337309ccac47c4b421f8dbae61ff73","city":"北京市市辖区","sport_type":"网球,篮球","name":"北京奥雅网球篮球场","address":"北京市昌平区天通苑东一区天通艺苑内（天通苑塔楼附近）","phone":"010-81778908","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/261e3a687a4b4fae98be1d1eb9be9e8b","geo":"40.080987,116.444356","isRating":"0","grade":10,"orderTotal":9,"sportList":[{"TENNIS":{"statiumPrice":50,"qiuyouPrice":38}}]},{"dist":20.201703089066182,"id":"729b46383414400aa9e8d908b1b4c747","city":"北京市市辖区","sport_type":"篮球,足球,羽毛球,网球","name":"云趣园社区篮球俱乐部  ","address":"北京市昌平区回龙观云趣园二区西门","phone":"13520510595","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/d12ae08735324787b19bdf0296f49650","geo":"40.089253,116.335899","isRating":"0","grade":8,"orderTotal":1,"sportList":[{"BADMINTON":{"statiumPrice":60,"qiuyouPrice":55}}]},{"dist":22.1982549665949,"id":"06b00cfa0fef4548b2fddf571fbad501","city":"北京市市辖区","sport_type":"羽毛球,网球,乒乓球,台球,篮球","name":"用友波力体育馆","address":"北清路68号西五区\t","phone":"010-62434013","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/ca699834c0854e6e8924cbe2f11ad5ca","geo":"40.071353,116.241582","isRating":"0","grade":8,"orderTotal":0,"sportList":[{"BADMINTON":{"statiumPrice":40,"qiuyouPrice":38}}]},{"dist":31.68626267493704,"id":"19deef1459824463a459409a8427cf3f","city":"北京市市辖区","sport_type":"羽毛球,篮球,乒乓球","name":"北京顺义林河索菲特羽毛球馆","address":"北京市顺义区仁和镇林河村后破路8号","phone":"010-89498328","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/9a8e36f1a7074dc19cd6d29a00a95c37","geo":"40.096729,116.69074","isRating":"0","grade":8,"orderTotal":0,"sportList":[{"BADMINTON":{"statiumPrice":40,"qiuyouPrice":31}}]},{"dist":36.971009785014374,"id":"d1bdcab6122347618c099f73a1d6b69c","city":"北京市市辖区","sport_type":"羽毛球,足球,篮球,网球","name":"北京金勾体育运动中心","address":"北京市昌平区菓岭小镇东门","phone":"010-80106666","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/0e61f9c5366f411d8ab7e833a4a1e479","geo":"40.232263,116.273084","isRating":"0","grade":8,"orderTotal":1,"sportList":[{"BADMINTON":{"statiumPrice":60,"qiuyouPrice":42}}]},{"dist":4.269802847020035,"id":"f0dc4e7dfe484cb3a55e97877db12a8a","city":"北京市市辖区","sport_type":"篮球","name":"西城区体育场篮球场 ","address":"西城区登莱胡同与白广路交汇处北侧\t","phone":"010-63544114","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/2aae0fb7ea1246dab34635aed20575ad","geo":"39.893028,116.363099","isRating":"0","grade":1,"orderTotal":9,"sportList":[{"BASKETBALL":{"statiumPrice":15,"qiuyouPrice":15}}]},{"dist":5.627117539146583,"id":"97c4d2bbfadb4afa8ade410dddc46149","city":"北京市市辖区","sport_type":"篮球","name":"龙迈东方篮球俱乐部 ","address":"北京市朝阳区东直门外斜街8号 ","phone":"18911608263","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/de65c5438d5e4016af992925808a1d78","geo":"39.95228,116.448888","isRating":"0","grade":8,"orderTotal":1,"sportList":[{"BASKETBALL":{"statiumPrice":300,"qiuyouPrice":215}}]}]}
     */

    private StatiumBeanBean statiumBean;

    public StatiumBeanBean getStatiumBean() {
        return statiumBean;
    }

    public void setStatiumBean(StatiumBeanBean statiumBean) {
        this.statiumBean = statiumBean;
    }

    public static class StatiumBeanBean {
        /**
         * pageSize : 10
         * pageNo : 1
         * totalCount : 105
         * totalPage : 11
         * data : [{"dist":6.179330644348899,"id":"38bfb0bebcfa490e93463b13882c98b3","city":"北京市市辖区","sport_type":"篮球","name":"华腾园室外篮球场 ","address":"朝阳区东三环南路54号院","phone":"13020000280","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/822bbff01ec344d58bda4f5dfb5acdcd","geo":"39.893279,116.470514","isRating":"0","grade":8,"orderTotal":8,"sportList":[{"BASKETBALL":{"statiumPrice":150,"qiuyouPrice":135}}]},{"dist":10.42455821677228,"id":"b86106eeb1cf44dab346bec3839d6269","city":"北京市市辖区","sport_type":"篮球,网球","name":"北京艾锐斯体育（篮球，网球）","address":"北京市北京市海淀区学院路18号","phone":"18610873888","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/9ef62a2ab4f348d884efec69cc5ef01f","geo":"40.004357,116.366079","isRating":"0","grade":10,"orderTotal":59,"sportList":[{"BASKETBALL":{"statiumPrice":150,"qiuyouPrice":142}}]},{"dist":16.492934697864214,"id":"e5d857cbbddc425da06a20168e7605fb","city":"北京市市辖区","sport_type":"篮球,羽毛球","name":"优肯智能篮球馆（天秀）","address":"北京市海淀区龙背村路","phone":"010-57163936","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/2583549bade34c28b8c5204882e60221","geo":"40.027807,116.277961","isRating":"0","grade":9,"orderTotal":11,"sportList":[{"BADMINTON":{"statiumPrice":40,"qiuyouPrice":36}}]},{"dist":18.751556868295964,"id":"15337309ccac47c4b421f8dbae61ff73","city":"北京市市辖区","sport_type":"网球,篮球","name":"北京奥雅网球篮球场","address":"北京市昌平区天通苑东一区天通艺苑内（天通苑塔楼附近）","phone":"010-81778908","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/261e3a687a4b4fae98be1d1eb9be9e8b","geo":"40.080987,116.444356","isRating":"0","grade":10,"orderTotal":9,"sportList":[{"TENNIS":{"statiumPrice":50,"qiuyouPrice":38}}]},{"dist":20.201703089066182,"id":"729b46383414400aa9e8d908b1b4c747","city":"北京市市辖区","sport_type":"篮球,足球,羽毛球,网球","name":"云趣园社区篮球俱乐部  ","address":"北京市昌平区回龙观云趣园二区西门","phone":"13520510595","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/d12ae08735324787b19bdf0296f49650","geo":"40.089253,116.335899","isRating":"0","grade":8,"orderTotal":1,"sportList":[{"BADMINTON":{"statiumPrice":60,"qiuyouPrice":55}}]},{"dist":22.1982549665949,"id":"06b00cfa0fef4548b2fddf571fbad501","city":"北京市市辖区","sport_type":"羽毛球,网球,乒乓球,台球,篮球","name":"用友波力体育馆","address":"北清路68号西五区\t","phone":"010-62434013","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/ca699834c0854e6e8924cbe2f11ad5ca","geo":"40.071353,116.241582","isRating":"0","grade":8,"orderTotal":0,"sportList":[{"BADMINTON":{"statiumPrice":40,"qiuyouPrice":38}}]},{"dist":31.68626267493704,"id":"19deef1459824463a459409a8427cf3f","city":"北京市市辖区","sport_type":"羽毛球,篮球,乒乓球","name":"北京顺义林河索菲特羽毛球馆","address":"北京市顺义区仁和镇林河村后破路8号","phone":"010-89498328","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/9a8e36f1a7074dc19cd6d29a00a95c37","geo":"40.096729,116.69074","isRating":"0","grade":8,"orderTotal":0,"sportList":[{"BADMINTON":{"statiumPrice":40,"qiuyouPrice":31}}]},{"dist":36.971009785014374,"id":"d1bdcab6122347618c099f73a1d6b69c","city":"北京市市辖区","sport_type":"羽毛球,足球,篮球,网球","name":"北京金勾体育运动中心","address":"北京市昌平区菓岭小镇东门","phone":"010-80106666","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/0e61f9c5366f411d8ab7e833a4a1e479","geo":"40.232263,116.273084","isRating":"0","grade":8,"orderTotal":1,"sportList":[{"BADMINTON":{"statiumPrice":60,"qiuyouPrice":42}}]},{"dist":4.269802847020035,"id":"f0dc4e7dfe484cb3a55e97877db12a8a","city":"北京市市辖区","sport_type":"篮球","name":"西城区体育场篮球场 ","address":"西城区登莱胡同与白广路交汇处北侧\t","phone":"010-63544114","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/2aae0fb7ea1246dab34635aed20575ad","geo":"39.893028,116.363099","isRating":"0","grade":1,"orderTotal":9,"sportList":[{"BASKETBALL":{"statiumPrice":15,"qiuyouPrice":15}}]},{"dist":5.627117539146583,"id":"97c4d2bbfadb4afa8ade410dddc46149","city":"北京市市辖区","sport_type":"篮球","name":"龙迈东方篮球俱乐部 ","address":"北京市朝阳区东直门外斜街8号 ","phone":"18911608263","photo_list":"http://fileserver.qiuyouzone.com/fileserver/get/de65c5438d5e4016af992925808a1d78","geo":"39.95228,116.448888","isRating":"0","grade":8,"orderTotal":1,"sportList":[{"BASKETBALL":{"statiumPrice":300,"qiuyouPrice":215}}]}]
         */

        private int pageSize;
        private int pageNo;
        private int totalCount;
        private int totalPage;
        private List<DataBean> data;

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * dist : 6.179330644348899
             * id : 38bfb0bebcfa490e93463b13882c98b3
             * city : 北京市市辖区
             * sport_type : 篮球
             * name : 华腾园室外篮球场
             * address : 朝阳区东三环南路54号院
             * phone : 13020000280
             * photo_list : http://fileserver.qiuyouzone.com/fileserver/get/822bbff01ec344d58bda4f5dfb5acdcd
             * geo : 39.893279,116.470514
             * isRating : 0
             * grade : 8
             * orderTotal : 8
             * sportList : [{"BASKETBALL":{"statiumPrice":150,"qiuyouPrice":135}}]
             */

            private double dist;
            private String id;
            private String city;
            private String sport_type;
            private String name;
            private String address;
            private String phone;
            private String photo_list;
            private String geo;
            private String isRating;
            private String top;
            private int grade;
            private int orderTotal;
            private double lat;
            private double lng;

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public String getTop() {
                return top;
            }

            public void setTop(String top) {
                this.top = top;
            }

            public List<Map<String, StatiumPrice>> sportList;

            public double getDist() {
                return dist;
            }

            public void setDist(double dist) {
                this.dist = dist;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getSport_type() {
                return sport_type;
            }

            public void setSport_type(String sport_type) {
                this.sport_type = sport_type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPhoto_list() {
                return photo_list;
            }

            public void setPhoto_list(String photo_list) {
                this.photo_list = photo_list;
            }

            public String getGeo() {
                return geo;
            }

            public void setGeo(String geo) {
                this.geo = geo;
            }

            public String getIsRating() {
                return isRating;
            }

            public void setIsRating(String isRating) {
                this.isRating = isRating;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }

            public int getOrderTotal() {
                return orderTotal;
            }

            public void setOrderTotal(int orderTotal) {
                this.orderTotal = orderTotal;
            }

            public List<Map<String, StatiumPrice>> getSportList() {
                return sportList;
            }

            public void setSportList(List<Map<String, StatiumPrice>> sportList) {
                this.sportList = sportList;
            }



                public class StatiumPrice {

                    public String qiuyouPrice;
                    public String statiumPrice;
                }

        }
    }
}
