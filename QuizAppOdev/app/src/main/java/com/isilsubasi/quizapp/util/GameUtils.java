package com.isilsubasi.quizapp.util;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.model.QuestionModel;

import java.util.ArrayList;

public class GameUtils {

    public static ArrayList<QuestionModel> setAndroidQuestionsLibrary(){

        ArrayList<QuestionModel> androidQuestionsList=new ArrayList<QuestionModel>();
        androidQuestionsList.add(new QuestionModel(
                "Soru1",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap B"


        ));
        androidQuestionsList.add(new QuestionModel(
                "Soru2",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap C"


        ));
        androidQuestionsList.add(new QuestionModel(
                "Soru3",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap D"


        ));
        androidQuestionsList.add(new QuestionModel(
                "Soru4",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap A"


        ));
        androidQuestionsList.add(new QuestionModel(
                "Soru5",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap C"


        ));
        androidQuestionsList.add(new QuestionModel(
                "Soru6",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap D"


        ));
        androidQuestionsList.add(new QuestionModel(
                "Soru7",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap A"


        ));
        androidQuestionsList.add(new QuestionModel(
                "Soru8",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap C"


        ));
        androidQuestionsList.add(new QuestionModel(
                "Soru9",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap A"


        ));
        androidQuestionsList.add(new QuestionModel(
                "Soru10",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap D"


        ));

    return androidQuestionsList;

    }

    public static void setJavaQuestionsLibrary(){
        ArrayList javaQuestionsList=new ArrayList<QuestionModel>();
        javaQuestionsList.add(new QuestionModel(
                "Soru1",
                "cevap A",
                "cevap B",

                "cevap C",
                "cevap D",
                "cevap B"


        ));
        javaQuestionsList.add(new QuestionModel(
                "Soru2",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap A"


        ));
        javaQuestionsList.add(new QuestionModel(
                "Soru3",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap D"


        ));
        javaQuestionsList.add(new QuestionModel(
                "Soru4",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap B"


        ));
        javaQuestionsList.add(new QuestionModel(
                "Soru5",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap A"


        ));
        javaQuestionsList.add(new QuestionModel(
                "Soru6",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap C"


        ));
        javaQuestionsList.add(new QuestionModel(
                "Soru7",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap D"


        ));
        javaQuestionsList.add(new QuestionModel(
                "Soru8",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap B"


        ));
        javaQuestionsList.add(new QuestionModel(
                "Soru9",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap D"


        ));
        javaQuestionsList.add(new QuestionModel(
                "Soru10",
                "cevap A",
                "cevap B",
                "cevap C",
                "cevap D",
                "cevap A"


        ));

    }

    public static void buttonPaint(Activity activity, Button button , int color){
        button.setBackgroundColor(activity.getResources().getColor(color));

    }






}
