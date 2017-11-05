package com.fighter.superframe.gloable;

import android.app.Application;
import android.content.Context;

import com.adups.trace.Trace;
import com.fighter.superframe.BuildConfig;
import com.fighter.superframe.utils.LogUtils;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public class MeiziApp extends Application {

    private static final String TAG = MeiziApp.class.getSimpleName();
    public static Context sCx;

    @Override
    public void onCreate() {
        super.onCreate();
        sCx = getApplicationContext();
        LogUtils.getConfig().setLogSwitch(BuildConfig.DEBUG_MODE);
        initUmeng();
    }

    private void initUmeng() {
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Trace.d(TAG, "onSuccess() " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Trace.d(TAG, "onFailure() " + s + "," + s1);
            }
        });
    }
}
