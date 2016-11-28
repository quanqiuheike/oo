// (c)2016 Flipboard Inc, All Rights Reserved.

package com.polysoft.threecarpenter;

import android.app.Application;
import android.content.SharedPreferences;

public class MyApplication extends Application {
    private static final String SP_NAME = "config";
    private static MyApplication INSTANCE;
    private static SharedPreferences sp;

    public static MyApplication getInstance() {

        return INSTANCE;
    }

    public MyApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        sp = getSharedPreferences(SP_NAME, MODE_PRIVATE);
    }

    public static String getStringSP(String key) {
        return sp.getString(key, "");
    }

    public static boolean getBooleanSP(String key) {
        return sp.getBoolean(key, false);
    }

    public static long getLongSP(String key) {
        return sp.getLong(key, 0L);
    }

    public static void setStringSP(String key, String value) {
        sp.edit().putString(key, value).commit();
    }

    public static void setBooleanSP(String key, boolean value) {
        sp.edit().putBoolean(key, value).commit();
    }

    public static void setLongSP(String key, long value) {
        sp.edit().putLong(key, value).commit();
    }


}
