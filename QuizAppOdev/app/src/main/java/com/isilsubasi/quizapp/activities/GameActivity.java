package com.isilsubasi.quizapp.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.model.QuestionModel;
import com.isilsubasi.quizapp.util.ActivityUtils;
import com.isilsubasi.quizapp.util.Constans;
import com.isilsubasi.quizapp.util.GameUtils;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    TextView txtGameBar,txtQuestionNumber,txtScore,txtQuestion;
    Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4;
    CardView cardGameBar;
    String gameBarCategoryName , answerString;
    int counter=0,score=100 , questionLength;
    ArrayList<String> buttonList;


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
        btnAnswer1 =findViewById(R.id.btn_option_one);
        btnAnswer2 =findViewById(R.id.btn_option_two);
        btnAnswer3 =findViewById(R.id.btn_option_three);
        btnAnswer4 =findViewById(R.id.btn_option_four);
        cardGameBar=findViewById(R.id.cardGameBar);
        setCardGameBar();
        setGameStart();
        setClickListeners();
    }

    private void setCardGameBar(){
        gameBarCategoryName=getIntent().getExtras().getString(Constans.GAME_BAR_PARAMETRESI);
        int gameBarComingColorValue=getIntent().getExtras().getInt(Constans.GAME_BAR_COLOR);
        txtGameBar.setText(gameBarCategoryName);
        cardGameBar.setCardBackgroundColor(gameBarComingColorValue);
    }

    private void setGameStart(){
            if (gameBarCategoryName.equals(Constans.ANDROID)){
                  updateAndroidQuestions();
            }else{
                  //Java soru cevap
            }
    }

    @SuppressLint("SetTextI18n")
    private void updateAndroidQuestions(){
        ArrayList<QuestionModel> androidQuestionsList=GameUtils.setAndroidQuestionsLibrary();
        questionLength=androidQuestionsList.size();

        txtQuestionNumber.setText(counter+"/"+questionLength);
        txtScore.setText(""+score);
        txtQuestion.setText(androidQuestionsList.get(counter).getQuestion());
        btnAnswer1.setText(androidQuestionsList.get(counter).getAnswer1());
        btnAnswer2.setText(androidQuestionsList.get(counter).getAnswer2());
        btnAnswer3.setText(androidQuestionsList.get(counter).getAnswer3());
        btnAnswer4.setText(androidQuestionsList.get(counter).getAnswer4());
        answerString=androidQuestionsList.get(counter).getCorrectAnswer();



    }


    private void setClickListeners(){

        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswer1);
            }
        });


        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswer2);
            }
        });

        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswer3);
            }
        });

        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswer4);
            }
        });


    }


    private void checkAnswer(Button btnAnswer){

        if (btnAnswer.getText() == answerString){
            GameUtils.buttonPaint(GameActivity.this,btnAnswer,R.color.light_green);
            //1 saniyelik timer
        }else{
            GameUtils.buttonPaint(GameActivity.this,btnAnswer,R.color.red);
            ActivityUtils.openGameOverActivity(GameActivity.this,GameOverActivity.class);
        }


    }











}
