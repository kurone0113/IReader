package com.kurone.ireader.utils;

import android.content.SharedPreferences;

import com.kurone.ireader.app.App;

import static android.content.Context.MODE_PRIVATE;

/**
 * SharedPreferences utils class. Created by Kurone on 2017/4/20.
 */

public class SPUtils {
    private static SharedPreferences sp;

    public static void writeBoolean(String key, boolean value) {
        sp = App.app.getSharedPreferences("Settings", MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }

    public static boolean readBoolean(String key) {
        sp = App.app.getSharedPreferences("Settings", MODE_PRIVATE);
        return sp.getBoolean(key, true);
    }

}
