package com.fighter.superframe;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.HTTP;
import retrofit2.http.Path;

/**
 * Created by fighter_lee on 2017/8/3.
 */

public interface BlogService {

    @HTTP(method = "GET")
    Call<ResponseBody>getBlog(@Path("id")int id);

}
