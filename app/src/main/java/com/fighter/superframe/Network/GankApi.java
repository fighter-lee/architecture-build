package com.fighter.superframe.Network;


import com.fighter.superframe.info.AndroidInfo;
import com.fighter.superframe.info.GankDateInfo;
import com.fighter.superframe.info.GankInfo;
import com.fighter.superframe.info.ImageInfo;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by fighter_lee on 2017/8/4.
 */

public interface GankApi {

    @GET("search")
    Call<List<ImageInfo>> search(@Query("q") String query);

    /**
     * 全路径替换url，覆盖baseurl
     *
     * @param url
     * @return
     */
    @GET
    Call<ResponseBody> getFuli(@Url String url);

    /**
     * "data/福利/{number}/{page}"中的number和page将会被@Path参数替换
     * 拓长性强于{@link #getFuli2(String, String)}
     *
     * @param number
     * @param page
     * @return
     */
    @HTTP(method = "GET", path = "data/福利/{number}/{page}", hasBody = false)
    Call<ResponseBody> getFuli1(@Path("number") String number, @Path("page") String page);

    /**
     * 上面方法的简写形式
     *
     * @param number
     * @param page
     * @return
     */
    @GET("data/福利/{number}/{page}")
    Call<ResponseBody> getFuli2(@Path("number") String number, @Path("page") String page);

    /**
     * 使用Gson将json转成bean，需要添加addConverterFactory(GsonConverterFactory.create())
     * {@link Network#getGankApi()}
     *
     * @param number
     * @param page
     * @return
     */
    @GET("data/福利/{number}/{page}")
    Call<ImageInfo> getFuliWithGson(@Path("number") String number, @Path("page") String page);

    //--------------rxjava----------------
    @GET("data/福利/{number}/{page}")
    Observable<ImageInfo> getRxFuli(@Path("number") String number, @Path("page") String page);


    @GET("data/Android/{number}/{page}")
    Observable<ResponseBody> getAndroid(@Path("number") String number, @Path("page") String page);

    @GET("data/Android/{number}/{page}")
    Observable<AndroidInfo> getRxAndroidInfo(@Path("number") String number, @Path("page") String page);

    @GET("data/{type}/{number}/{page}")
    Observable<GankInfo> getGankInfo(@Path("type") String type, @Path("number") String number, @Path("page") String page);

    @GET("day/{year}/{month}/{day}")
    Observable<GankDateInfo> getGankDateInfo(@Path("year") String year, @Path("month") String month, @Path("day") String day);
}
