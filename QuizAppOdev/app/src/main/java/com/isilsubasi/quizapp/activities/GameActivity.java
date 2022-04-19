package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.util.Constans;

public class GameActivity extends AppCompatActivity {

    TextView tvGameBar;
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
        cardGameBar=findViewById(R.id.cardGameBar);

    }


}