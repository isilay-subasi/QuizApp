package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.util.Constans;

public class GameActivity extends AppCompatActivity {

    TextView tvGameBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initThis();
        String comingValue=getIntent().getExtras().getString(Constans.GAME_BAR_PARAMETRESI);
        tvGameBar.setText(comingValue);
    }



    public void initThis(){

        tvGameBar=findViewById(R.id.tv_game_bar);


    }


}