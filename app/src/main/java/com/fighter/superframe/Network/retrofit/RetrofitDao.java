package com.fighter.superframe.Network.retrofit;

import com.fighter.superframe.BuildConfig;
import com.fighter.superframe.Network.NetworkConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author fighter-lee
 * @date 2017/11/4 0004
 */
public class RetrofitDao {

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private Retrofit mRetrofit;

    public static Retrofit buildRetrofit(IBuildPublicParams iBuildPublicParams, CookieJar cookieJar) {
        return new RetrofitDao(iBuildPublicParams, cookieJar).mRetrofit;
    }

    public static Retrofit buildRetrofit(IBuildPublicParams iBuildPublicParams) {
        return new RetrofitDao(iBuildPublicParams, new CookieJar() {
            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {

            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                return new ArrayList<>();
            }
        }).mRetrofit;
    }

    private RetrofitDao(IBuildPublicParams iBuildPublicParams, CookieJar cookieJar) {
        if (mRetrofit == null) {
            if (NetworkConfig.getBaseUrl() == null || NetworkConfig.getBaseUrl().trim().equals("")) {
                throw new RuntimeException("需要设置baseurl");
            }
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(BuildConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(BuildConfig.WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(BuildConfig.READ_TIMEOUT, TimeUnit.SECONDS)
                    .cookieJar(cookieJar)
                    .addInterceptor(new HttpInterceptor(iBuildPublicParams))
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build();
            Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(NetworkConfig.getBaseUrl())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
    }


    public interface IBuildPublicParams {
        /**
         * 添加公共的参数
         * @param builder
         * @return
         */
        HttpUrl.Builder buildPublicParams(HttpUrl.Builder builder);
    }
}
