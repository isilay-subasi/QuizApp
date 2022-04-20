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
import com.isilsubasi.quizapp.util.Constans;
import com.isilsubasi.quizapp.util.GameUtils;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    TextView txtGameBar,txtQuestionNumber,txtScore,txtQuestion;
    Button  btnAnswerOne,btnAnswerTwo,btnAnswerThree,btnAnswerFour;
    CardView cardGameBar;
    String gameBarCategoryName;
    int counter=0,score=100 , questionLength , answerIndex;


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
        setCardGameBar();
        updateQuestionsAndAnswers();
        setClickListeners();
    }

    private void setCardGameBar(){
        gameBarCategoryName=getIntent().getExtras().getString(Constans.GAME_BAR_PARAMETRESI);
        int gameBarComingColorValue=getIntent().getExtras().getInt(Constans.GAME_BAR_COLOR);
        txtGameBar.setText(gameBarCategoryName);
        cardGameBar.setCardBackgroundColor(gameBarComingColorValue);
    }

    private void updateQuestionsAndAnswers(){
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
        btnAnswerOne.setText(androidQuestionsList.get(counter).getAnswer1());
        btnAnswerTwo.setText(androidQuestionsList.get(counter).getAnswer2());
        btnAnswerThree.setText(androidQuestionsList.get(counter).getAnswer3());
        btnAnswerFour.setText(androidQuestionsList.get(counter).getAnswer4());
        answerIndex=androidQuestionsList.get(counter).getCorrectAnswerIndex();


    }


    private void setClickListeners(){

        btnAnswerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswerOne);
            }
        });


        btnAnswerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswerTwo);
            }
        });

        btnAnswerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswerThree);
            }
        });

        btnAnswerFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(btnAnswerFour);
            }
        });


    }


    private void checkAnswer(Button btnAnswer){





    }




}
