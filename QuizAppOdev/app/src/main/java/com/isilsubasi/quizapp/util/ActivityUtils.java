package com.isilsubasi.quizapp.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashMap;


public class ActivityUtils {

    public static void openScreen(Activity activity, Class<?> cls,boolean isFinish){
        Intent intent=new Intent(activity, cls);
        activity.startActivity(intent);
        if (isFinish){
            activity.finish();
        }

    }



    public static void openActivityWithParams(Activity activity, Class<?> cls, HashMap<String,String> extras){
        Intent intent=new Intent(activity,cls);
        for(HashMap.Entry<String, String> item : extras.entrySet()) {
            intent.putExtra(item.getKey(),item.getValue());
        }
        activity.startActivity(intent);
        activity.finish();
    }




}
