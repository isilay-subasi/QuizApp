package com.isilsubasi.quizapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.util.GameUtils;

public class GameActivity extends AppCompatActivity {

    TextView txtGameBar,txtQuestionNumber,txtScore,txtQuestion;
    Button  btnAnswerOne,btnAnswerTwo,btnAnswerThree,btnAnswerFour;
    CardView cardGameBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initUI();



    }


    private void initUI(){
        txtGameBar=findViewById(R.id.tv_game_bar);
        txtQuestionNumber=findViewById(R.id.tv_question_number);
        txtScore=findViewById(R.id.tv_question_score);
        txtQuestion=findViewById(R.id.tv_question);
        btnAnswerOne=findViewById(R.id.btn_option_one);
        btnAnswerTwo=findViewById(R.id.btn_option_two);
        btnAnswerThree=findViewById(R.id.btn_option_three);
        btnAnswerFour=findViewById(R.id.btn_option_four);
        cardGameBar=findViewById(R.id.cardGameBar);
        GameUtils.setCardGameBar(this,txtGameBar,cardGameBar);

    }


}
