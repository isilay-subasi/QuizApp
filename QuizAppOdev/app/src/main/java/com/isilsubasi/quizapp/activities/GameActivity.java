package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.util.Constans;

public class GameActivity extends AppCompatActivity {

    TextView tvGameBar,tvQuestionNumber,tvQuestionScore,tvQuestion;
    Button  btnOptionOne,btnOptionTwo,btnOptionThree,bntOptionFour;
    CardView cardGameBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initThis();
        String gameBarComingValue=getIntent().getExtras().getString(Constans.GAME_BAR_PARAMETRESI);
        int gameBarComingColorValue=getIntent().getExtras().getInt(Constans.GAME_BAR_COLOR);
        tvGameBar.setText(gameBarComingValue);
        cardGameBar.setCardBackgroundColor(gameBarComingColorValue);
    }



    public void initThis(){

        tvGameBar=findViewById(R.id.tv_game_bar);
        tvQuestionNumber=findViewById(R.id.tv_question_number);
        tvQuestionScore=findViewById(R.id.tv_question_score);
        tvQuestion=findViewById(R.id.tv_question);

        btnOptionOne=findViewById(R.id.btn_option_one);
        btnOptionTwo=findViewById(R.id.btn_option_two);
        btnOptionThree=findViewById(R.id.btn_option_three);
        bntOptionFour=findViewById(R.id.btn_option_four);

        cardGameBar=findViewById(R.id.cardGameBar);

    }


}