package com.fighter.superframe.utils;

import android.content.Context;

import com.fighter.superframe.gloable.MeiziApp;

import java.io.File;

/**
 * Created by fighter_lee on 2017/9/27.
 */

public class FileUtils {

    public static Context getContext() {
        return MeiziApp.sCx;
    }

    public static String getCacheDir() {
        String path = getContext().getCacheDir() + File.separator + "cache";
        File file = new File(path);
        if (createOrExistsDir(file)) {
            return path;
        } else {
            return "";
        }
    }

    /**
     * 判断目录是否存在，不存在则判断是否创建成功
     *
     * @param file 文件
     * @return {@code true}: 存在或创建成功<br>{@code false}: 不存在或创建失败
     */
    public static boolean createOrExistsDir(File file) {
        // 如果存在，是目录则返回true，是文件则返回false，不存在则返回是否创建成功
        return file != null && (file.exists() ? file.isDirectory() : file.mkdirs());
    }
}
