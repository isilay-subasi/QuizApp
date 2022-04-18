package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.activities.LoginActivity;

//Uygulama başladığında ekranda gözüken ilk aktivitedir.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3 saniye sonra diğer ekrana geçmesi için oluşturulmuş fonksiyondur.
        countDownTimerFunction(3000,1000);


    }



    /*
    Aşağıdaki fonksiyon 3 saniyelik bir timer başlatır ve bittiğinde LoginActivity
    ekranını açıp bu ekranı öldürür.
     */
    public void countDownTimerFunction(int milis,int interval){
        //3000 milisaniye - 3 saniyeye denk gelir.
        //interval - aralık
        new CountDownTimer(milis, interval) {

            //OnTick metodu geri sayım süresince yapılacak değişiklikler
            @Override
            public void onTick(long l) {

            }

            //süre bittiğinde yapılacaklar
            @Override
            public void onFinish() {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();

            }
        }.start();



    }



}