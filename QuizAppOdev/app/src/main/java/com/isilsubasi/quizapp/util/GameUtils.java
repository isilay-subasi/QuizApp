package com.isilsubasi.quizapp.util;

import android.app.Activity;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.isilsubasi.quizapp.model.QuestionModel;

import java.util.ArrayList;

public class GameUtils {


    public static void setQuestionLibrary(){

        ArrayList questionLibraryList=new ArrayList<QuestionModel>();
        questionLibraryList.add(new QuestionModel(
                "Soru1",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                1


        ));
        questionLibraryList.add(new QuestionModel(
                "Soru2",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                1


        ));
        questionLibraryList.add(new QuestionModel(
                "Soru3",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                1


        ));
        questionLibraryList.add(new QuestionModel(
                "Soru4",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                1


        ));
        questionLibraryList.add(new QuestionModel(
                "Soru5",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                1


        ));
        questionLibraryList.add(new QuestionModel(
                "Soru6",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                1


        ));
        questionLibraryList.add(new QuestionModel(
                "Soru7",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                1


        ));
        questionLibraryList.add(new QuestionModel(
                "Soru8",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                1


        ));
        questionLibraryList.add(new QuestionModel(
                "Soru9",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                1


        ));
        questionLibraryList.add(new QuestionModel(
                "Soru10",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                1


        ));



    }

    public static void setCardGameBar(Activity activity, TextView txtView, CardView cardView){
        String gameBarCategoryName=activity.getIntent().getExtras().getString(Constans.GAME_BAR_PARAMETRESI);
        int gameBarComingColorValue=activity.getIntent().getExtras().getInt(Constans.GAME_BAR_COLOR);
        txtView.setText(gameBarCategoryName);
        cardView.setCardBackgroundColor(gameBarComingColorValue);
    }

}
