package com.fighter.superframe.gloable;

import android.app.Application;

import com.adups.trace.Trace;

/**
 * Created by fighter_lee on 2017/8/8.
 */

public class MeiziApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initTrace();
    }

    private void initTrace() {
        Trace.setLevel(Trace.DEBUG);
        Trace.setShowPosition(true);
    }
}
