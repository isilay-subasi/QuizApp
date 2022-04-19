package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.activities.LoginActivity;
import com.isilsubasi.quizapp.util.Constans;

//Uygulama başladığında ekranda gözüken ilk aktivitedir.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SplashScreenTimer splashScreenTimer=new SplashScreenTimer(Constans.SPLASH_SCREEN_TIMER_MILIS,Constans.SPLASH_SCREEN_INVERTAL_MILIS);
        splashScreenTimer.start();



    }

    /*
    Aşağıdaki class CountDownTimer'dan kalıtım alır.
    Ve nesne oluşturulduğu yerde nesnenin içerisine girilen parameteye bağlı olarak zamanlayıcı oluşturarak,
    süre bitince LoginActivity.class açar.
     */

    class SplashScreenTimer extends CountDownTimer{

        public SplashScreenTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        //Geri sayım süresince yapılacak değişiklikler
        @Override
        public void onTick(long l) {

        }
        ///süre bittiğinde yapılacaklar
        @Override
        public void onFinish() {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }




}