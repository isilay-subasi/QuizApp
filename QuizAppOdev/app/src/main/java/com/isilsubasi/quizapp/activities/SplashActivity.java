package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.util.ActivityUtils;
import com.isilsubasi.quizapp.util.Constans;

//Uygulama başladığında ekranda gözüken ilk aktivitedir.
public class SplashActivity extends AppCompatActivity {

    //Uygulama çalışırken ilk girilen metotdur.
    //Layout olarak activity_main.xml set edilmiştir.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashIt();
    }

    /*
    Uygulama açıldıktan belli bir süre sonra LoginActivity ekranına geçiş yapmasını sağlayan zamanlayıcı.
    Bu süreyi Constanslardan vererek zamanı değiştirmek istediğimizde tek bir yerden değiştirmeyi sağlayabiliriz.
    (Projede 3 saniye olarak belirledik.)
     */

     private void splashIt(){
        new CountDownTimer(Constans.SPLASH_SCREEN_TIMER_MILIS,Constans.INVERTAL_MILIS) {
            @Override
            public void onTick(long l) { }

            @Override
            public void onFinish() {
                ActivityUtils.openScreen(SplashActivity.this,LoginActivity.class);
            }
        }.start();
     }







}