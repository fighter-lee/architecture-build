package com.fighter.superframe.Network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fighter_lee on 2017/8/4.
 */

public class Network {

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static GankApi gankApi;
    private static IotApi iotApi;

    public static GankApi getGankApi() {
        if (gankApi == null) {
            gankApi = new Retrofit.Builder()
                    .baseUrl("http://gank.io/api/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(GankApi.class);
        }
        return gankApi;
    }

    public static IotApi getIOTApi() {
        if (iotApi == null) {
            iotApi = new Retrofit.Builder()
                    .baseUrl("http://iotapi.adups.com/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(IotApi.class);
        }
        return iotApi;
    }

}
