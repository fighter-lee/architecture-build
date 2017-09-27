package com.fighter.superframe.utils;

import com.adups.trace.Trace;

/**
 * Created by fighter_lee on 2017/9/27.
 */

public class NetworkUtils {

    /**
     * 判断网络是否可用
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.INTERNET"/>}</p>
     *
     * @return {@code true}: 可用<br>{@code false}: 不可用
     */
    public static boolean isAvailableByPing() {
        ShellUtils.CommandResult result = ShellUtils.execCmd("ping -c 1 -w 1 223.5.5.5", false);
        boolean ret = result.result == 0;
        if (result.errorMsg != null) {
            Trace.d("isAvailableByPing errorMsg", result.errorMsg);
        }
        if (result.successMsg != null) {
            Trace.d("isAvailableByPing successMsg", result.successMsg);
        }
        return ret;
    }


}
