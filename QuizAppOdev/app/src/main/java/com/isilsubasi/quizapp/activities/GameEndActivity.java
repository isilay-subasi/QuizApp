package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.util.ActivityUtils;
import com.isilsubasi.quizapp.util.Constans;
import com.isilsubasi.quizapp.util.PrefUtil;

public class GameEndActivity extends AppCompatActivity {


    TextView txtQuestionNumber , txtScore;
    Button btnBackToHomePage , btnExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_end);
        initUI();
        ActivityUtils.setGameOverAndGameEndActivity(GameEndActivity.this,btnBackToHomePage,btnExit,txtQuestionNumber,txtScore);

    }

    private void initUI(){
        txtQuestionNumber=findViewById(R.id.txtQuestionNumber);
        txtScore=findViewById(R.id.txtScore);
        btnBackToHomePage=findViewById(R.id.btnBackToHomePage);
        btnExit=findViewById(R.id.btnExit);


    }




}