package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.model.QuestionAndroidLibrary;
import com.isilsubasi.quizapp.util.Constans;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView tvGameBar,tvQuestionNumber,tvQuestionScore,tvQuestion;
    Button  btnOptionOne,btnOptionTwo,btnOptionThree,bntOptionFour;
    CardView cardGameBar;
    QuestionAndroidLibrary questionAndroidLibrary;
    String answer;
    int questionLength;
    int score=0;
    int number=0;
    boolean isCorrect=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initThis();
        String gameBarCategoryName=getIntent().getExtras().getString(Constans.GAME_BAR_PARAMETRESI);
        int gameBarComingColorValue=getIntent().getExtras().getInt(Constans.GAME_BAR_COLOR);
        tvGameBar.setText(gameBarCategoryName);
        cardGameBar.setCardBackgroundColor(gameBarComingColorValue);

        /*
            Eğer intent ile gelen game bar üzerinde yazılacak kategori adı(gameBarCategoryName)
            "ANDROID" değerine eşit ise Android kategorisindeki soruların ve cevapların gösterilmesi gerekir.
         */
        if (gameBarCategoryName.equals(Category.ANDROID.name())){
                updateQuestionAndroid(number,score);


        }
        /*
            2 kategori kullandığım için burda else bloğunda Java kategorisi seçilmiş olur.
            Ve burada da Java ile ilgili soruların ve cevapların gösterilmesi gerekir.
         */
        else{

        }

        btnOptionOne.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if (btnOptionOne.getText() == answer){

                    number++;
                    score=score+10;
                    isCorrect=true;
                    btnOptionOne.setBackgroundColor(getResources().getColor(R.color.light_green));
                    questionChangeTimerStart(number,score,btnOptionOne);
                }else{
                    btnOptionOne.setBackgroundColor(getResources().getColor(R.color.red));
                    isCorrect=false;
                    questionChangeTimerStart(number,score,btnOptionOne);

                }
            }
        });

        btnOptionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnOptionTwo.getText() == answer){
                    Toast.makeText(getApplicationContext(), "doğru", Toast.LENGTH_SHORT).show();
                    number++;
                    score=score+10;
                    updateQuestionAndroid(number,score);
                }else{
                    Toast.makeText(getApplicationContext(), "yanlış", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnOptionThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnOptionThree.getText() == answer){
                    Toast.makeText(getApplicationContext(), "doğru", Toast.LENGTH_SHORT).show();
                    number++;
                    score=score+10;
                    updateQuestionAndroid(number,score);
                }else{
                    Toast.makeText(getApplicationContext(), "yanlış", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bntOptionFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bntOptionFour.getText() == answer){
                    Toast.makeText(getApplicationContext(), "doğru", Toast.LENGTH_SHORT).show();
                    number++;
                    score=score+10;
                    updateQuestionAndroid(number,score);
                }else{
                    Toast.makeText(getApplicationContext(), "yanlış", Toast.LENGTH_SHORT).show();
                }
            }
        });


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

        questionAndroidLibrary=new QuestionAndroidLibrary();
        questionLength=questionAndroidLibrary.questions.length;


    }

    @SuppressLint("SetTextI18n")
    public void updateQuestionAndroid(int number, int score){

        tvQuestionNumber.setText(number + "/" + questionLength);
        tvQuestionScore.setText(""+score);
        tvQuestion.setText(questionAndroidLibrary.getQuestion(number));
        btnOptionOne.setText(questionAndroidLibrary.getChoiceOne(number));
        btnOptionTwo.setText(questionAndroidLibrary.getChoiceTwo(number));
        btnOptionThree.setText(questionAndroidLibrary.getChoiceThree(number));
        bntOptionFour.setText(questionAndroidLibrary.getChoiceFour(number));

        answer=questionAndroidLibrary.getCorrectAnswer(number);

    }



    enum Category {
        ANDROID,
        JAVA,
    }

    public void questionChangeTimerStart(int number,int score,Button choseBtn){
        new CountDownTimer(Constans.QUESTION_CHANGE_TIMER_MILIS,Constans.QUESTION_CHANGE_INVERTAL_MILIS) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {


                choseBtn.setBackgroundColor(getResources().getColor(R.color.light_pink_color));

                if (isCorrect){
                    AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
                    builder.setTitle("Cevap Doğru");
                    builder.setNegativeButton("Çıkış",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            }

                    );
                    builder.setPositiveButton("Devam", new
                            DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    updateQuestionAndroid(number,score);

                                }
                            });

                    builder.show();
                }
                else{
                    Intent intent=new Intent(getApplicationContext(),GameOverActivity.class);
                    startActivity(intent);
                }
            }
        }.start();


    }


}