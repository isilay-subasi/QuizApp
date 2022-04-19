package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
    int score=100;
    int number=0;

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
                updateQuestionAndroid(number);


        }
        /*
            2 kategori kullandığım için burda else bloğunda Java kategorisi seçilmiş olur.
            Ve burada da Java ile ilgili soruların ve cevapların gösterilmesi gerekir.
         */
        else{

        }

        btnOptionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnOptionOne.getText() == answer){
                    Toast.makeText(getApplicationContext(), "doğru", Toast.LENGTH_SHORT).show();
                    number++;
                    updateQuestionAndroid(number);
                }else{
                    Toast.makeText(getApplicationContext(), "yanlış", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnOptionTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btnOptionTwo.getText() == answer){
                    Toast.makeText(getApplicationContext(), "doğru", Toast.LENGTH_SHORT).show();
                    number++;
                    updateQuestionAndroid(number);
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
                    updateQuestionAndroid(number);
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
                    updateQuestionAndroid(number);
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
    public void updateQuestionAndroid(int number){

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

}