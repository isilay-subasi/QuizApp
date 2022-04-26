package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    int screenId =-1;
    String questioNumber,score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_finish);
        initUI();
        receivedData();
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
        screenId =Integer.parseInt(getIntent().getStringExtra(Constans.MOVED_SCREEN_PARAMETER));
        questioNumber=getIntent().getStringExtra(Constans.QUESTION_NUMBER_PARAMETER);
        score=getIntent().getStringExtra(Constans.SCORE_PARAMETER);
    }



    @Override
    public void getImage(int id) {
        if (screenId== Screens.WİNNER.getValue()){
            imageViewEmoji.setImageResource(R.drawable.happy_emoji);
        }else {
            imageViewEmoji.setImageResource(R.drawable.sad_emoji);
        }




    }

    @Override
    public void getDescription(int id) {
        if (screenId== Screens.WİNNER.getValue()){
            txtFinishText.setText(getResources().getString(R.string.game_end_text));
        }else {
            txtFinishText.setText(getResources().getString(R.string.game_over_text));
        }
    }

    @Override
    public void onButtonClick(int id) {
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