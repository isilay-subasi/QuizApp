package com.isilsubasi.quizapp.activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.model.QuestionModel;
import com.isilsubasi.quizapp.util.ActivityUtils;
import com.isilsubasi.quizapp.util.Constans;
import com.isilsubasi.quizapp.util.Screens;
import com.isilsubasi.quizapp.util.GameUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class GameActivity extends AppCompatActivity {

    TextView txtGameBar,txtQuestionNumber,txtScore,txtQuestion;
    Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4;
    CardView cardGameBar;
    String gameBarCategoryName , answerString;
    HashMap<String,String> HashMap=new HashMap<>();
    int counter=1,score=0 , questionLength;
    boolean isCorrect=false;

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
        gameBarCategoryName=getIntent().getExtras().getString(Constans.GAME_BAR_PARAMETER);
        txtGameBar.setText(gameBarCategoryName);
        cardGameBar.setCardBackgroundColor(Integer.parseInt(getIntent().getExtras().getString(Constans.GAME_BAR_COLOR)));
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
        txtQuestion.setText(androidQuestionsList.get(counter-1).getQuestion());
        btnAnswer1.setText(androidQuestionsList.get(counter-1).getAnswer1());
        btnAnswer2.setText(androidQuestionsList.get(counter-1).getAnswer2());
        btnAnswer3.setText(androidQuestionsList.get(counter-1).getAnswer3());
        btnAnswer4.setText(androidQuestionsList.get(counter-1).getAnswer4());
        answerString=androidQuestionsList.get(counter-1).getCorrectAnswer();

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
            counter++;
            score=score+10;
            isCorrect=true;
            btnAnswer.setBackgroundColor(getResources().getColor(R.color.light_green));
        }else{
            isCorrect=false;
            btnAnswer.setBackgroundColor(getResources().getColor(R.color.red));
        }
        continueDialogTimer(btnAnswer);


    }



 private void continueDialogTimer(Button btnAnswer){
     new CountDownTimer(Constans.DIALOG_OPENING_TIMER,Constans.INVERTAL_MILIS) {
         @Override
         public void onTick(long l) { }

         @RequiresApi(api = Build.VERSION_CODES.N)
         @Override
         public void onFinish() {
             if (isCorrect){
                 showContinueDialog(btnAnswer);
             }else{
                 HashMap = createHashMap(Screens.WRONG.name());
                 ActivityUtils.openActivityWithParams(GameActivity.this,GameFinishActivity.class,HashMap);
             }


         }
     }.start();


     ;

 }

    public  void showContinueDialog(Button btnAnswer){
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        builder.setTitle(getString(R.string.alert_title_continue));
        builder.setNegativeButton(getString(R.string.exit_button),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }
        );
        builder.setPositiveButton(getString(R.string.alert_devam_button), new
                DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        if (isLastQuestion(counter)){
                            HashMap = createHashMap(Screens.WINNER.name());
                            ActivityUtils.openActivityWithParams(GameActivity.this,GameFinishActivity.class,HashMap);

                        }else {
                            dialog.dismiss();
                            btnAnswer.setBackgroundColor(getResources().getColor(R.color.light_pink_color));
                            updateAndroidQuestions();
                        }


                    }
                });
        builder.show();


    }

    private boolean isLastQuestion(int counter){
        if (counter==questionLength+1){
            return true;
        }
        return false;
    }


    private HashMap<String,String> createHashMap(String screenName){
        HashMap.put(Constans.MOVED_SCREEN_PARAMETER, screenName);
        HashMap.put(Constans.QUESTION_NUMBER_PARAMETER, String.valueOf(counter));
        HashMap.put(Constans.SCORE_PARAMETER, String.valueOf(score));
        HashMap.put(Constans.QUESTION_LENGTH_PARAMETER, String.valueOf(questionLength));
        return HashMap;
    }



}
