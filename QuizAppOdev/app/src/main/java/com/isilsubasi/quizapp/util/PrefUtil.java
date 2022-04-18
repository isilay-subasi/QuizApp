package com.isilsubasi.quizapp.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefUtil {

    private static SharedPreferences getPref(Context context){

        return PreferenceManager.getDefaultSharedPreferences(context);

    }

    public static void setStringPref(Context context,String key,String deger){
        getPref(context).edit().putString(key,deger).apply();

    }

    public static String getStringPref(Context context,String key){
        return getPref(context).getString(key,"..");

    }
}
