package com.fighter.superframe.gloable;

import android.app.Application;
import android.content.Context;

import com.fighter.superframe.BuildConfig;
import com.fighter.superframe.utils.LogUtils;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

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
        initPush();

    }

    private void initPush() {
        XGPushConfig.enableDebug(this,BuildConfig.DEBUG_MODE);
        XGPushManager.registerPush(this, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object data, int flag) {
                //token在设备卸载重装的时候有可能会变
                LogUtils.d("TPush", "注册成功，设备token为：" + data);
            }
            @Override
            public void onFail(Object data, int errCode, String msg) {
                LogUtils.d("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
            }
        });
    }

}
