package com.fighter.superframe.info;

import java.util.List;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public class AndroidInfo {


    /**
     * error : false
     * results : [{"_id":"5985bdb6421aa97de5c7ca30","createdAt":"2017-08-05T20:44:38.849Z","desc":"由于RxJava发布了一个订阅后，由于没有及时取消，会导致内存泄露，本文介绍Rxlifecycle机制","publishedAt":"2017-08-08T11:34:20.37Z","source":"web","type":"Android","url":"http://url.cn/4Es2B0l","used":true,"who":"Tamic (码小白)"},{"_id":"5988179b421aa90c9203d47b","createdAt":"2017-08-07T15:32:43.864Z","desc":"Android8.0运行时权限策略变化和适配方案","publishedAt":"2017-08-08T11:34:20.37Z","source":"web","type":"Android","url":"http://blog.csdn.net/yanzhenjie1003/article/details/76719487","used":true,"who":"严振杰"}]
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
         * _id : 5985bdb6421aa97de5c7ca30
         * createdAt : 2017-08-05T20:44:38.849Z
         * desc : 由于RxJava发布了一个订阅后，由于没有及时取消，会导致内存泄露，本文介绍Rxlifecycle机制
         * publishedAt : 2017-08-08T11:34:20.37Z
         * source : web
         * type : Android
         * url : http://url.cn/4Es2B0l
         * used : true
         * who : Tamic (码小白)
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
