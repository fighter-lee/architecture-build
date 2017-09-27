package com.fighter.superframe.info;

import java.util.List;

/**
 * Created by fighter_lee on 2017/9/26.
 */

public class GankDateInfo {

    /**
     * category : ["Android","休息视频","前端","福利","App","瞎推荐","拓展资源","iOS"]
     * error : false
     * results : {"Android":[{"_id":"59924c1b421aa9672cdf080a","createdAt":"2017-08-15T09:19:23.763Z","desc":"值得你学习的 Android 开发规范","publishedAt":"2017-08-21T11:38:57.363Z","source":"web","type":"Android","url":"http://url.cn/4EiVI5e","used":true,"who":"陈宇明"},{"_id":"599699ec421aa967262e1c40","createdAt":"2017-08-18T15:40:28.709Z","desc":"Wifi扫描和连接","publishedAt":"2017-08-21T11:38:57.363Z","source":"web","type":"Android","url":"http://blog.csdn.net/onepiece2/article/details/75302534","used":true,"who":"BirdGuo"},{"_id":"599a38db421aa901c1c0a857","createdAt":"2017-08-21T09:35:23.556Z","desc":"Android 富文本编辑器（UI仿WPS）","images":["http://img.gank.io/1a4b1c1b-6ca6-44d0-aa6e-a2af36e5c162"],"publishedAt":"2017-08-21T11:38:57.363Z","source":"api","type":"Android","url":"https://github.com/Even201314/MRichEditor","used":true,"who":"Android"},{"_id":"599a46df421aa901c85e5fa0","createdAt":"2017-08-21T10:35:11.415Z","desc":"Android 周日历视图组件。","images":["http://img.gank.io/8ab58632-895f-4912-a2cf-f89c1b831296"],"publishedAt":"2017-08-21T11:38:57.363Z","source":"chrome","type":"Android","url":"https://github.com/alamkanak/Android-Week-View","used":true,"who":"代码家"},{"_id":"599a48c7421aa901c85e5fa2","createdAt":"2017-08-21T10:43:19.851Z","desc":"Android Expresso 增强组件。","images":["http://img.gank.io/107e7a5d-1a88-4040-8f0d-9197366f74c4"],"publishedAt":"2017-08-21T11:38:57.363Z","source":"chrome","type":"Android","url":"https://github.com/blipinsk/cortado","used":true,"who":"Blo"}],"App":[{"_id":"59a53723421aa901c1c0a8a3","createdAt":"2017-08-29T17:42:59.847Z","desc":"360°全景图 DroidVR，这是一个值得把玩的APP","images":["http://img.gank.io/54608c97-7557-4633-ae79-51712f4f413c"],"publishedAt":"2017-09-01T12:55:52.582Z","source":"web","type":"App","url":"https://github.com/sfsheng0322/DroidVR","used":true,"who":"孙福生"}],"iOS":[{"_id":"599a482a421aa901c85e5fa1","createdAt":"2017-08-21T10:40:42.831Z","desc":"ARKit 实现的超级玛丽，好逼真啊。","images":["http://img.gank.io/68a0ef31-a2ad-4364-bbd4-f8d1f15b59fe"],"publishedAt":"2017-08-21T11:38:57.363Z","source":"chrome","type":"iOS","url":"https://github.com/bjarnel/arkit-smb-homage","used":true,"who":"S"}],"休息视频":[{"_id":"59944134421aa96729c57251","createdAt":"2017-08-16T20:57:24.255Z","desc":"【谷阿莫】5分鐘看完2017不要一個人去拉屎的電影《异形：契约 Alien- Covenant》","publishedAt":"2017-08-21T11:38:57.363Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av13399068/","used":true,"who":"LHF"}],"前端":[{"_id":"59956786421aa9672f354ddc","createdAt":"2017-08-17T17:53:10.396Z","desc":"前端每周清单半年盘点之 Node.js 篇","publishedAt":"2017-08-21T11:38:57.363Z","source":"web","type":"前端","url":"https://zhuanlan.zhihu.com/p/28584218","used":true,"who":"王下邀月熊(Chevalier)"}],"拓展资源":[{"_id":"599a416a421aa901c1c0a859","createdAt":"2017-08-21T10:11:54.707Z","desc":"开源版 EverNote。","publishedAt":"2017-08-21T11:38:57.363Z","source":"chrome","type":"拓展资源","url":"https://github.com/Laverna/laverna","used":true,"who":"代码家"}],"瞎推荐":[{"_id":"56cc6d1d421aa95caa707763","createdAt":"2015-08-08T16:04:47.987Z","desc":"高吞吐量系统设计优化建议","publishedAt":"2015-08-20T01:28:34.744Z","type":"瞎推荐","url":"http://www.importnew.com/16464.html","used":true,"who":"LHF"}],"福利":[{"_id":"599a299a421aa901b9dc460f","createdAt":"2017-08-21T08:30:18.487Z","desc":"8-21","publishedAt":"2017-08-21T11:38:57.363Z","source":"chrome","type":"福利","url":"https://ws1.sinaimg.cn/large/610dc034ly1fir1jbpod5j20ip0newh3.jpg","used":true,"who":"daimajia"}]}
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

    public static class DataBean{}

    public static class ResultsBean {
        private List<AndroidBean> Android;
        private List<AppBean> App;
        private List<IOSBean> iOS;
        private List<休息视频Bean> 休息视频;
        private List<前端Bean> 前端;
        private List<拓展资源Bean> 拓展资源;
        private List<瞎推荐Bean> 瞎推荐;
        private List<福利Bean> 福利;

        public List<AndroidBean> getAndroid() {
            return Android;
        }

        public void setAndroid(List<AndroidBean> Android) {
            this.Android = Android;
        }

        public List<AppBean> getApp() {
            return App;
        }

        public void setApp(List<AppBean> App) {
            this.App = App;
        }

        public List<IOSBean> getIOS() {
            return iOS;
        }

        public void setIOS(List<IOSBean> iOS) {
            this.iOS = iOS;
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

        public List<瞎推荐Bean> get瞎推荐() {
            return 瞎推荐;
        }

        public void set瞎推荐(List<瞎推荐Bean> 瞎推荐) {
            this.瞎推荐 = 瞎推荐;
        }

        public List<福利Bean> get福利() {
            return 福利;
        }

        public void set福利(List<福利Bean> 福利) {
            this.福利 = 福利;
        }

        public static class AndroidBean extends DataBean{
            /**
             * _id : 59924c1b421aa9672cdf080a
             * createdAt : 2017-08-15T09:19:23.763Z
             * desc : 值得你学习的 Android 开发规范
             * publishedAt : 2017-08-21T11:38:57.363Z
             * source : web
             * type : Android
             * url : http://url.cn/4EiVI5e
             * used : true
             * who : 陈宇明
             * images : ["http://img.gank.io/1a4b1c1b-6ca6-44d0-aa6e-a2af36e5c162"]
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

        public static class AppBean implements DataBean{
            /**
             * _id : 59a53723421aa901c1c0a8a3
             * createdAt : 2017-08-29T17:42:59.847Z
             * desc : 360°全景图 DroidVR，这是一个值得把玩的APP
             * images : ["http://img.gank.io/54608c97-7557-4633-ae79-51712f4f413c"]
             * publishedAt : 2017-09-01T12:55:52.582Z
             * source : web
             * type : App
             * url : https://github.com/sfsheng0322/DroidVR
             * used : true
             * who : 孙福生
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

        public static class IOSBean {
            /**
             * _id : 599a482a421aa901c85e5fa1
             * createdAt : 2017-08-21T10:40:42.831Z
             * desc : ARKit 实现的超级玛丽，好逼真啊。
             * images : ["http://img.gank.io/68a0ef31-a2ad-4364-bbd4-f8d1f15b59fe"]
             * publishedAt : 2017-08-21T11:38:57.363Z
             * source : chrome
             * type : iOS
             * url : https://github.com/bjarnel/arkit-smb-homage
             * used : true
             * who : S
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
             * _id : 59944134421aa96729c57251
             * createdAt : 2017-08-16T20:57:24.255Z
             * desc : 【谷阿莫】5分鐘看完2017不要一個人去拉屎的電影《异形：契约 Alien- Covenant》
             * publishedAt : 2017-08-21T11:38:57.363Z
             * source : chrome
             * type : 休息视频
             * url : http://www.bilibili.com/video/av13399068/
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
             * _id : 59956786421aa9672f354ddc
             * createdAt : 2017-08-17T17:53:10.396Z
             * desc : 前端每周清单半年盘点之 Node.js 篇
             * publishedAt : 2017-08-21T11:38:57.363Z
             * source : web
             * type : 前端
             * url : https://zhuanlan.zhihu.com/p/28584218
             * used : true
             * who : 王下邀月熊(Chevalier)
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

        public static class 拓展资源Bean {
            /**
             * _id : 599a416a421aa901c1c0a859
             * createdAt : 2017-08-21T10:11:54.707Z
             * desc : 开源版 EverNote。
             * publishedAt : 2017-08-21T11:38:57.363Z
             * source : chrome
             * type : 拓展资源
             * url : https://github.com/Laverna/laverna
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

        public static class 瞎推荐Bean {
            /**
             * _id : 56cc6d1d421aa95caa707763
             * createdAt : 2015-08-08T16:04:47.987Z
             * desc : 高吞吐量系统设计优化建议
             * publishedAt : 2015-08-20T01:28:34.744Z
             * type : 瞎推荐
             * url : http://www.importnew.com/16464.html
             * used : true
             * who : LHF
             */

            private String _id;
            private String createdAt;
            private String desc;
            private String publishedAt;
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

        public static class 福利Bean {
            /**
             * _id : 599a299a421aa901b9dc460f
             * createdAt : 2017-08-21T08:30:18.487Z
             * desc : 8-21
             * publishedAt : 2017-08-21T11:38:57.363Z
             * source : chrome
             * type : 福利
             * url : https://ws1.sinaimg.cn/large/610dc034ly1fir1jbpod5j20ip0newh3.jpg
             * used : true
             * who : daimajia
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
