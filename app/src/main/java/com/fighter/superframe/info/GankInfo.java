package com.fighter.superframe.info;

import java.util.List;

/**
 * Created by fighter_lee on 2017/9/21.
 */

public class GankInfo {


    /**
     * error : false
     * results : [{"_id":"599cf342421aa901b9dc4628","createdAt":"2017-08-23T11:15:14.864Z","desc":"iOS 国旗旗帜集合，每个 icon 都非常漂亮。","images":["http://img.gank.io/7fb236c9-f96b-4554-9361-d4725c5bfd0b"],"publishedAt":"2017-08-23T12:12:15.166Z","source":"chrome","type":"iOS","url":"https://github.com/madebybowtie/FlagKit","used":true,"who":"代码家"},{"_id":"599b9961421aa901bcb7db81","createdAt":"2017-08-22T10:39:29.302Z","desc":"银行卡信用卡效果组件，很逼真啊。","images":["http://img.gank.io/f5f45e80-a968-4f08-b14a-5f83fb3f317d"],"publishedAt":"2017-08-22T12:02:15.769Z","source":"chrome","type":"iOS","url":"https://github.com/eliakorkmaz/iCard","used":true,"who":"S"},{"_id":"599a482a421aa901c85e5fa1","createdAt":"2017-08-21T10:40:42.831Z","desc":"ARKit 实现的超级玛丽，好逼真啊。","images":["http://img.gank.io/68a0ef31-a2ad-4364-bbd4-f8d1f15b59fe"],"publishedAt":"2017-08-21T11:38:57.363Z","source":"chrome","type":"iOS","url":"https://github.com/bjarnel/arkit-smb-homage","used":true,"who":"S"},{"_id":"598c1db2421aa90ca209c58b","createdAt":"2017-08-10T16:47:46.44Z","desc":"用户体验极佳的干货集中营 iOS App","images":["http://img.gank.io/218bcc4e-8d85-479d-b8ce-0d674eb38ef8"],"publishedAt":"2017-08-15T13:32:36.998Z","source":"web","type":"iOS","url":"https://github.com/yeziahehe/Gank","used":true,"who":"Fan Ye"},{"_id":"59911759421aa9672f354db2","createdAt":"2017-08-14T11:22:01.227Z","desc":"通过 Kalman filter （卡尔曼滤波）解决 GPS 抖动路径记录问题。","images":["http://img.gank.io/03f69bd1-49b6-4028-a66d-421e0b28f372"],"publishedAt":"2017-08-14T17:04:50.266Z","source":"chrome","type":"iOS","url":"https://github.com/Hypercubesoft/HCKalmanFilter","used":true,"who":"S"},{"_id":"59911788421aa967262e1c1a","createdAt":"2017-08-14T11:22:48.804Z","desc":"利用 AR Kit 来精确测量长度，有意思。","images":["http://img.gank.io/af0bf1fe-3195-445f-875a-4b14ce30b90c"],"publishedAt":"2017-08-14T17:04:50.266Z","source":"chrome","type":"iOS","url":"https://github.com/levantAJ/Measure","used":true,"who":"代码家"},{"_id":"599117ed421aa9672f354db5","createdAt":"2017-08-14T11:24:29.855Z","desc":"炫酷的下载按钮！","publishedAt":"2017-08-14T17:04:50.266Z","source":"chrome","type":"iOS","url":"https://github.com/MagicBlind/Download-Button","used":true,"who":"S"},{"_id":"59916664421aa96729c57240","createdAt":"2017-08-14T16:59:16.344Z","desc":"iOS优秀第三方开源库汇总，收藏备用","publishedAt":"2017-08-14T17:04:50.266Z","source":"chrome","type":"iOS","url":"http://blog.csdn.net/x32sky/article/details/77112964","used":true,"who":"x32sky"},{"_id":"598d28a5421aa97de5c7ca5a","createdAt":"2017-08-11T11:46:45.578Z","desc":"A drop-in replacement for UICollectionViewFlowLayout","images":["http://img.gank.io/42c469c0-013e-4994-8b83-af02cb362d12"],"publishedAt":"2017-08-11T14:05:53.749Z","source":"chrome","type":"iOS","url":"https://github.com/devxoul/UICollectionViewFlexLayout","used":true,"who":"S"},{"_id":"598d28d3421aa90c9203d49a","createdAt":"2017-08-11T11:47:31.557Z","desc":"可伸展的 Table Cell","publishedAt":"2017-08-11T14:05:53.749Z","source":"chrome","type":"iOS","url":"https://github.com/rob-nash/CollapsibleTable","used":true,"who":"S"}]
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
         * _id : 599cf342421aa901b9dc4628
         * createdAt : 2017-08-23T11:15:14.864Z
         * desc : iOS 国旗旗帜集合，每个 icon 都非常漂亮。
         * images : ["http://img.gank.io/7fb236c9-f96b-4554-9361-d4725c5bfd0b"]
         * publishedAt : 2017-08-23T12:12:15.166Z
         * source : chrome
         * type : iOS
         * url : https://github.com/madebybowtie/FlagKit
         * used : true
         * who : 代码家
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
