package com.rwby.mytask.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 文件保存
 * Created by anJuBao on 2015/6/10.
 */
public class SharedPref {
    private SharedPreferences sp;

    public SharedPref(Context context, String fileName) {
        sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    public void setInteger(String key, int value) {
        SharedPreferences.Editor e = sp.edit();
        e.putInt(key, value);
        e.apply();
    }

    public int getInteger(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    public void setBoolean(String key, boolean value) {
        SharedPreferences.Editor e = sp.edit();
        e.putBoolean(key, value);
        e.apply();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    public void setLong(String key, long value) {
        SharedPreferences.Editor e = sp.edit();
        e.putLong(key, value);
        e.apply();
    }

    public Long getLong(String key, long defValue) {
        return sp.getLong(key, defValue);
    }

    public void setString(String key, String value) {
        SharedPreferences.Editor e = sp.edit();
        e.putString(key, value);
        e.apply();
    }

    public String getString(String key, String defaultV) {
        return sp.getString(key, defaultV);
    }
}
