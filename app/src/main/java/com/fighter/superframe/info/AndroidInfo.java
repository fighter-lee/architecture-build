package com.fighter.superframe.info;

import java.util.List;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public class AndroidInfo {


    /**
     * error : false
     * results : [{"_id":"597e016c421aa90ca209c523","createdAt":"2017-07-30T23:55:24.154Z","desc":"Android终端","publishedAt":"2017-09-21T13:27:15.675Z","source":"chrome","type":"Android","url":"https://github.com/termux/termux-app","used":true,"who":"Jason"},{"_id":"597f2861421aa90ca209c527","createdAt":"2017-07-31T20:53:53.217Z","desc":"Google从 API 21 新增了接口 android.app.usage , 通过这个api我们可以统计到每个app的使用情况，启动次数，启动时间等，也可以判断是否前后台，比较方便。","images":["http://img.gank.io/c778f7da-b580-490b-961d-34706a57d326"],"publishedAt":"2017-09-21T13:27:15.675Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/bdf47afe110d","used":true,"who":"Tamic (码小白)"},{"_id":"5980492b421aa90ca209c533","createdAt":"2017-08-01T17:26:03.968Z","desc":"内存泄漏简要分析","publishedAt":"2017-09-21T13:27:15.675Z","source":"web","type":"Android","url":"https://zhuanlan.zhihu.com/p/28169456?group_id=874607398092935168","used":true,"who":"Li Wenjing"},{"_id":"59c3201e421aa9727ddd19b6","createdAt":"2017-09-21T10:12:46.866Z","desc":"安卓版本的VegaScroll","images":["http://img.gank.io/22a7d123-7776-4954-8f73-176ad9e18ddf"],"publishedAt":"2017-09-21T13:27:15.675Z","source":"web","type":"Android","url":"https://github.com/xmuSistone/VegaLayoutManager","used":true,"who":"stone"},{"_id":"59bbe478421aa9118c8262ca","createdAt":"2017-09-15T22:32:24.21Z","desc":"Android上取代HashMap的ArrayMap","images":["http://img.gank.io/a87f186b-47cc-44a4-98c7-a2dd05576fe7"],"publishedAt":"2017-09-20T13:17:38.709Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/088b9383f974","used":true,"who":"Niekon"},{"_id":"59bf3bb0421aa9118887ac35","createdAt":"2017-09-18T11:21:20.893Z","desc":"Glide v4最全中文文档来了！","publishedAt":"2017-09-20T13:17:38.709Z","source":"web","type":"Android","url":"https://github.com/Muyangmin/glide-docs-cn","used":true,"who":"Muyangmin"},{"_id":"59c1c557421aa9727fdb25c3","createdAt":"2017-09-20T09:33:11.73Z","desc":"你知道APP从启动到主页面显示经历了哪些过程吗？","publishedAt":"2017-09-20T13:17:38.709Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s?__biz=MzIwMzYwMTk1NA==&mid=2247487014&idx=1&sn=ce2e5378d0dd8a8bc6b85358a8aaa47c","used":true,"who":"陈宇明"},{"_id":"59c1d24d421aa972845f2077","createdAt":"2017-09-20T10:28:29.264Z","desc":"全民 Google ARCore，解决官方不支持设备问题","publishedAt":"2017-09-20T13:17:38.709Z","source":"web","type":"Android","url":"https://github.com/tomthecarrot/arcore-for-all","used":true},{"_id":"59b7909f421aa911847a0391","createdAt":"2017-09-12T15:45:35.132Z","desc":"View的事件分发机制\u2014\u2014由浅入深解析","publishedAt":"2017-09-19T12:07:31.405Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/e6ceb7f767d8","used":true,"who":"匡罡"},{"_id":"59bfe526421aa911847a03b3","createdAt":"2017-09-18T23:24:22.545Z","desc":"一个简约番茄时钟的实现思路","images":["http://img.gank.io/cc9e461f-3e8d-456f-bba5-e15b80509dfb"],"publishedAt":"2017-09-19T12:07:31.405Z","source":"web","type":"Android","url":"http://rkhcy.github.io/2017/09/18/TomatoView%E5%AE%9E%E7%8E%B0/","used":true,"who":"HuYounger"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 597e016c421aa90ca209c523
         * createdAt : 2017-07-30T23:55:24.154Z
         * desc : Android终端
         * publishedAt : 2017-09-21T13:27:15.675Z
         * source : chrome
         * type : Android
         * url : https://github.com/termux/termux-app
         * used : true
         * who : Jason
         * images : ["http://img.gank.io/c778f7da-b580-490b-961d-34706a57d326"]
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
}
