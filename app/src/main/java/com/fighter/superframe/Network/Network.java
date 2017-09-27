package com.fighter.superframe.Network;

import com.adups.trace.Trace;
import com.fighter.superframe.utils.FileUtils;
import com.fighter.superframe.utils.NetworkUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fighter_lee on 2017/8/4.
 */

public class Network {

    private static GankApi gankApi;

    public static GankApi getGankApi() {
        if (gankApi == null) {
            synchronized (Network.class) {
                if (gankApi == null) {
                    new Network();
                }
            }
        }
        return gankApi;
    }

    public Network() {
        //添加日志拦截，用于查看json数据
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String s) {
                try {
                    String text = URLDecoder.decode(s, "utf-8");
                    Trace.d("NetRequest", "log() " + text);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
        //NONE、BASIC、HEADER、BODY
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        File cacheFile = new File(FileUtils.getCacheDir());
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .cache(cache)
                .build();


        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();

        gankApi = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GankApi.class);

    }

    class HttpCacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetworkUtils.isAvailableByPing()) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                Trace.d("Okhttp", "no network");
            }

            Response originalResponse = chain.proceed(request);
            if (NetworkUtils.isAvailableByPing()) {
                //有网的时候读接口上的@Headers里的配置，可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                        .removeHeader("Pragma")
                        .build();
            }
        }
    }
}
