package com.fighter.superframe.Network;

import com.fighter.superframe.Network.retrofit.RetrofitDao;

import okhttp3.HttpUrl;

/**
 * Created by fighter_lee on 2017/8/4.
 */

public class Network {

    private static GankApi gankApi;

    public static GankApi getGankApi() {
        if (gankApi == null) {
            synchronized (Network.class) {
                if (gankApi == null) {
                    gankApi = RetrofitDao.buildRetrofit(new RetrofitDao.IBuildPublicParams() {
                        @Override
                        public HttpUrl.Builder buildPublicParams(HttpUrl.Builder builder) {
                            return Network.buildPublicParams(builder);
                        }
                    }).create(GankApi.class);
                }
            }
        }
        return gankApi;
    }

    /**
     * 可以在这设置公共的参数
     * @param builder
     * @return
     */
    private static HttpUrl.Builder buildPublicParams(HttpUrl.Builder builder) {
//        builder.addQueryParameter("id", BuildConfig.id);
        return builder;
    }
}
