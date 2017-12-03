package com.fighter.superframe.gloable;

import android.app.Application;
import android.content.Context;

import com.fighter.superframe.BuildConfig;
import com.fighter.superframe.utils.LogUtils;

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
    }

}
