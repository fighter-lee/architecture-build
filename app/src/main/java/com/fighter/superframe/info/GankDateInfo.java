package com.fighter.superframe.info;

import java.util.List;

/**
 * Created by fighter_lee on 2017/9/26.
 */

public class GankDateInfo {


    /**
     * category : ["Android","休息视频","拓展资源","前端","福利"]
     * error : false
     * results : {"Android":[{"_id":"59bbe478421aa9118c8262ca","createdAt":"2017-09-15T22:32:24.21Z","desc":"Android上取代HashMap的ArrayMap","images":["http://img.gank.io/a87f186b-47cc-44a4-98c7-a2dd05576fe7"],"publishedAt":"2017-09-20T13:17:38.709Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/088b9383f974","used":true,"who":"Niekon"},{"_id":"59bf3bb0421aa9118887ac35","createdAt":"2017-09-18T11:21:20.893Z","desc":"Glide v4最全中文文档来了！","publishedAt":"2017-09-20T13:17:38.709Z","source":"web","type":"Android","url":"https://github.com/Muyangmin/glide-docs-cn","used":true,"who":"Muyangmin"},{"_id":"59c1c557421aa9727fdb25c3","createdAt":"2017-09-20T09:33:11.73Z","desc":"你知道APP从启动到主页面显示经历了哪些过程吗？","publishedAt":"2017-09-20T13:17:38.709Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247487014&idx=1&sn=ce2e5378d0dd8a8bc6b85358a8aaa47c","used":true,"who":"陈宇明"},{"_id":"59c1d24d421aa972845f2077","createdAt":"2017-09-20T10:28:29.264Z","desc":"全民 Google ARCore，解决官方不支持设备问题","publishedAt":"2017-09-20T13:17:38.709Z","source":"web","type":"Android","url":"https://github.com/tomthecarrot/arcore-for-all","used":true}],"休息视频":[{"_id":"59be78a8421aa911847a03a8","createdAt":"2017-09-17T21:29:12.58Z","desc":"【爆首映】《猩球崛起3》最大的亮点不是凯撒，而是宋小宝！","publishedAt":"2017-09-20T13:17:38.709Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av14549261/","used":true,"who":"LHF"}],"前端":[{"_id":"59c13901421aa9118787081f","createdAt":"2017-09-19T23:34:25.247Z","desc":"簡單實作手風琴特效菜單～","images":["http://img.gank.io/3c90c70b-2b75-4947-aee2-683652cd1c71"],"publishedAt":"2017-09-20T13:17:38.709Z","source":"web","type":"前端","url":"https://github.com/WeiChiaChang/vue-accordion-menu","used":true,"who":"WesleyChang"}],"拓展资源":[{"_id":"59c1332b421aa9118c8262e7","createdAt":"2017-09-19T23:09:31.114Z","desc":"Linux命令大全搜索工具，内容包含Linux命令手册、详解、学习、搜集。","images":["http://img.gank.io/2af62d9c-caba-4488-abcc-9f9c9a7846d9"],"publishedAt":"2017-09-20T13:17:38.709Z","source":"chrome","type":"拓展资源","url":"https://github.com/jaywcjlove/linux-command","used":true,"who":"lxxself"},{"_id":"59c1e34c421aa972845f207a","createdAt":"2017-09-20T11:41:00.91Z","desc":"Python 实现的人脸提取和识别引擎。","images":["http://img.gank.io/72124388-fba4-4465-b410-bdc11bf745c5"],"publishedAt":"2017-09-20T13:17:38.709Z","source":"chrome","type":"拓展资源","url":"https://github.com/ageitgey/face_recognition","used":true,"who":"代码家"}],"福利":[{"_id":"59c1b3e0421aa9727ddd19a8","createdAt":"2017-09-20T08:18:40.702Z","desc":"9-20","publishedAt":"2017-09-20T13:17:38.709Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fjppsiclufj20u011igo5.jpg","used":true,"who":"带马甲"}]}
     */

    private boolean error;
    private ResultsBean results;
    private List<String> category;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public static class ResultsBean {
        private List<AndroidBean> Android;
        private List<休息视频Bean> 休息视频;
        private List<前端Bean> 前端;
        private List<拓展资源Bean> 拓展资源;
        private List<福利Bean> 福利;

        public List<AndroidBean> getAndroid() {
            return Android;
        }

        public void setAndroid(List<AndroidBean> Android) {
            this.Android = Android;
        }

        public List<休息视频Bean> get休息视频() {
            return 休息视频;
        }

        public void set休息视频(List<休息视频Bean> 休息视频) {
            this.休息视频 = 休息视频;
        }

        public List<前端Bean> get前端() {
            return 前端;
        }

        public void set前端(List<前端Bean> 前端) {
            this.前端 = 前端;
        }

        public List<拓展资源Bean> get拓展资源() {
            return 拓展资源;
        }

        public void set拓展资源(List<拓展资源Bean> 拓展资源) {
            this.拓展资源 = 拓展资源;
        }

        public List<福利Bean> get福利() {
            return 福利;
        }

        public void set福利(List<福利Bean> 福利) {
            this.福利 = 福利;
        }

        public static class AndroidBean {
            /**
             * _id : 59bbe478421aa9118c8262ca
             * createdAt : 2017-09-15T22:32:24.21Z
             * desc : Android上取代HashMap的ArrayMap
             * images : ["http://img.gank.io/a87f186b-47cc-44a4-98c7-a2dd05576fe7"]
             * publishedAt : 2017-09-20T13:17:38.709Z
             * source : web
             * type : Android
             * url : http://www.jianshu.com/p/088b9383f974
             * used : true
             * who : Niekon
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 休息视频Bean {
            /**
             * _id : 59be78a8421aa911847a03a8
             * createdAt : 2017-09-17T21:29:12.58Z
             * desc : 【爆首映】《猩球崛起3》最大的亮点不是凯撒，而是宋小宝！
             * publishedAt : 2017-09-20T13:17:38.709Z
             * source : chrome
             * type : 休息视频
             * url : http://www.bilibili.com/video/av14549261/
             * used : true
             * who : LHF
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }

        public static class 前端Bean {
            /**
             * _id : 59c13901421aa9118787081f
             * createdAt : 2017-09-19T23:34:25.247Z
             * desc : 簡單實作手風琴特效菜單～
             * images : ["http://img.gank.io/3c90c70b-2b75-4947-aee2-683652cd1c71"]
             * publishedAt : 2017-09-20T13:17:38.709Z
             * source : web
             * type : 前端
             * url : https://github.com/WeiChiaChang/vue-accordion-menu
             * used : true
             * who : WesleyChang
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 拓展资源Bean {
            /**
             * _id : 59c1332b421aa9118c8262e7
             * createdAt : 2017-09-19T23:09:31.114Z
             * desc : Linux命令大全搜索工具，内容包含Linux命令手册、详解、学习、搜集。
             * images : ["http://img.gank.io/2af62d9c-caba-4488-abcc-9f9c9a7846d9"]
             * publishedAt : 2017-09-20T13:17:38.709Z
             * source : chrome
             * type : 拓展资源
             * url : https://github.com/jaywcjlove/linux-command
             * used : true
             * who : lxxself
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;
            private List<String> images;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }

        public static class 福利Bean {
            /**
             * _id : 59c1b3e0421aa9727ddd19a8
             * createdAt : 2017-09-20T08:18:40.702Z
             * desc : 9-20
             * publishedAt : 2017-09-20T13:17:38.709Z
             * source : chrome
             * type : 福利
             * url : https://ws1.sinaimg.cn/large/610dc034ly1fjppsiclufj20u011igo5.jpg
             * used : true
             * who : 带马甲
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
            private String source;
            private String type;
            private String url;
            private boolean used;
            private String who;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPublishedAt() {
                return publishedAt;
            }

            public void setPublishedAt(String publishedAt) {
                this.publishedAt = publishedAt;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public boolean isUsed() {
                return used;
            }

            public void setUsed(boolean used) {
                this.used = used;
            }

            public String getWho() {
                return who;
            }

            public void setWho(String who) {
                this.who = who;
            }
        }
    }
}
