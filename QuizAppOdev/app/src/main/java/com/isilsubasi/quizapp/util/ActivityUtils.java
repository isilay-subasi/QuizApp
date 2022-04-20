package com.isilsubasi.quizapp.util;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

import androidx.cardview.widget.CardView;


public class ActivityUtils {

    public static void openScreen(Activity activity, Class<?> cls){
        Intent intent=new Intent(activity, cls);
        activity.startActivity(intent);
        activity.finish();


    }

    public static void openGameActivity(Activity activity, Class<?> cls, TextView txtView , CardView cardView){
        Intent intent=new Intent(activity,cls);
        intent.putExtra(Constans.GAME_BAR_PARAMETRESI, txtView.getText().toString());
        intent.putExtra(Constans.GAME_BAR_COLOR,cardView.getCardBackgroundColor().getDefaultColor());
        activity.startActivity(intent);
    }


}
