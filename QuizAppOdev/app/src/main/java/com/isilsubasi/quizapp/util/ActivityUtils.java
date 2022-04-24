package com.isilsubasi.quizapp.util;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.isilsubasi.quizapp.activities.CategoryActivity;
import com.isilsubasi.quizapp.activities.GameEndActivity;
import com.isilsubasi.quizapp.activities.GameOverActivity;


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
        activity.finish();
    }


    public static void setGameOverAndGameEndActivity(Activity activity, Button btnBackToHomePage,Button btnExit ,TextView txtQuestionNumber,TextView txtScore){
        txtQuestionNumber.setText(String.valueOf(PrefUtil.getIntPref(activity, Constans.QUESTION_NUMBER_PARAMETER)));
        txtScore.setText(String.valueOf(PrefUtil.getIntPref(activity,Constans.SCORE_PARAMETER)));
        btnBackToHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.openScreen(activity, CategoryActivity.class);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               activity.finish();
            }
        });



    }



}
