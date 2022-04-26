package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.util.ActivityUtils;
import com.isilsubasi.quizapp.util.Constans;
import com.isilsubasi.quizapp.util.Screens;

public class GameFinishActivity extends AppCompatActivity implements Tasks{

    ImageView imageViewEmoji;
    TextView txtFinishText,txtQuestionNumber,txtScore;
    Button btnBackToHomePage,btnExit;
    String questionNumber,score,screenName , questionLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_finish);
        initUI();
        receivedData();
        getImage(screenName);
        getDescription(screenName);
        onButtonClick(screenName);
    }


    public void initUI(){
        imageViewEmoji=findViewById(R.id.imageViewEmoji);
        txtFinishText=findViewById(R.id.txtFinishText);
        txtQuestionNumber=findViewById(R.id.txtQuestionNumber);
        txtScore=findViewById(R.id.txtScore);
        btnBackToHomePage=findViewById(R.id.btnBackToHomePage);
        btnExit=findViewById(R.id.btnExit);
    }

    public void receivedData(){
        screenName =getIntent().getStringExtra(Constans.MOVED_SCREEN_PARAMETER);
        questionNumber =getIntent().getStringExtra(Constans.QUESTION_NUMBER_PARAMETER);
        score=getIntent().getStringExtra(Constans.SCORE_PARAMETER);
        questionLength=getIntent().getStringExtra(Constans.QUESTION_LENGTH_PARAMETER);
        Log.e("isil", questionNumber);
        Log.e("isil",score);
    }



    @Override
    public void getImage(String name) {
        if (screenName.equals(Screens.WİNNER.name())){
            imageViewEmoji.setImageResource(R.drawable.happy_emoji);
        }else {
            imageViewEmoji.setImageResource(R.drawable.sad_emoji);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void getDescription(String name) {
        if (screenName.equals(Screens.WİNNER.name())){
            txtFinishText.setText(getResources().getString(R.string.game_end_text));
            txtQuestionNumber.setText((Integer.parseInt(questionNumber)-1)+"/"+questionLength);
            txtScore.setText(score);
        }else {
            txtFinishText.setText(getResources().getString(R.string.game_over_text));
            txtQuestionNumber.setText(questionNumber+"/"+questionLength);
            txtScore.setText(score);
        }
    }

    @Override
    public void onButtonClick(String name) {
            btnBackToHomePage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityUtils.openScreen(GameFinishActivity.this,CategoryActivity.class,true);
                }
            });

            btnExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                      finish();
                }
            });


    }
}