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

    //Uygulama çalışırken ilk girilen metotdur.
    //Layout olarak activity_main.xml set edilmiştir.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashScreenTimerStart();



    }

    /*
    Uygulama açıldıktan belli bir süre sonra LoginActivity ekranına geçiş yapmasını sağlayan zamanlayıcı.
    Bu süreyi Constanslardan vererek zamanı değiştirmek istediğimizde tek bir yerden değiştirmeyi sağlayabiliriz.
    (Projede 3 saniye olarak belirledik.)
     */

     public void splashScreenTimerStart(){

        new CountDownTimer(Constans.SPLASH_SCREEN_TIMER_MILIS,Constans.SPLASH_SCREEN_INVERTAL_MILIS) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();

     }






}