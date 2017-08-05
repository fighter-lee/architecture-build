package com.fighter.superframe.Network;

import com.fighter.superframe.info.DeviceInfo;
import com.fighter.superframe.info.VersionInfo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by fighter_lee on 2017/8/4.
 */

public interface IotApi {

    /**
     * 用于下载
     * @param url
     * @return
     *
     * ResponseBody body = response.body();
     * long fileSize = body.contentLength();
     * InputStream inputStream = body.byteStream();
     */
    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url);

    /**
     * @Body:用于POST请求体，将实例对象根据转换方式转换为对应的json字符串参数，
     *  这个转化方式是GsonConverterFactory定义的。
     * @param productId
     * @param deviceInfo
     * @return
     */
    @POST("register/{productId}")
    Call<VersionInfo> register(@Path("productId") String productId, @Body DeviceInfo deviceInfo);
}
