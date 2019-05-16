package com.lucidastar.encapsulationhttp.otherhttp.mode;

import java.util.List;

/**
 * Created by qiuyouzone on 2019/5/10.
 */

public class UserModel {

    private List<ZoneInfoListBean> zoneInfoList;

    public List<ZoneInfoListBean> getZoneInfoList() {
        return zoneInfoList;
    }

    public void setZoneInfoList(List<ZoneInfoListBean> zoneInfoList) {
        this.zoneInfoList = zoneInfoList;
    }

    public static class ZoneInfoListBean {
        /**
         * id : a30b87b7790048a680afae1bc8def7b9
         * title : 韦德季后赛悬了？客战绿衫军，热火志在保八
         * cover : http://fileserver.qiuyouzone.com/fileserver/get/3b1716dec4ff452796981b94e7b7c994bigPicture
         * cover2 : http://fileserver.qiuyouzone.com/fileserver/get/af7dd71472cc479ea42b1657aef827d2bigPicture
         * cover3 : http://fileserver.qiuyouzone.com/fileserver/get/09c94750bd804e788e9c01f23e670fbcbigPicture
         * listContent :
         * commentNum : 42
         * source : 球友圈
         * resourceType : 1
         * watchNum : 0
         * lookNum : 4
         * et : 2019-04-16 16:54:18
         * dateDisplay : 2019-04-16
         * dateTimeDisplay : 2019-04-16 16:54
         */

        private String id;
        private String title;
        private String cover;
        private String cover2;
        private String cover3;
        private String listContent;
        private int commentNum;
        private String source;
        private int resourceType;
        private int watchNum;
        private int lookNum;
        private String et;
        private String dateDisplay;
        private String dateTimeDisplay;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCover2() {
            return cover2;
        }

        public void setCover2(String cover2) {
            this.cover2 = cover2;
        }

        public String getCover3() {
            return cover3;
        }

        public void setCover3(String cover3) {
            this.cover3 = cover3;
        }

        public String getListContent() {
            return listContent;
        }

        public void setListContent(String listContent) {
            this.listContent = listContent;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getResourceType() {
            return resourceType;
        }

        public void setResourceType(int resourceType) {
            this.resourceType = resourceType;
        }

        public int getWatchNum() {
            return watchNum;
        }

        public void setWatchNum(int watchNum) {
            this.watchNum = watchNum;
        }

        public int getLookNum() {
            return lookNum;
        }

        public void setLookNum(int lookNum) {
            this.lookNum = lookNum;
        }

        public String getEt() {
            return et;
        }

        public void setEt(String et) {
            this.et = et;
        }

        public String getDateDisplay() {
            return dateDisplay;
        }

        public void setDateDisplay(String dateDisplay) {
            this.dateDisplay = dateDisplay;
        }

        public String getDateTimeDisplay() {
            return dateTimeDisplay;
        }

        public void setDateTimeDisplay(String dateTimeDisplay) {
            this.dateTimeDisplay = dateTimeDisplay;
        }
    }
}
