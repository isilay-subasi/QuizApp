package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.activities.CategoryActivity;
import com.isilsubasi.quizapp.util.Constans;
import com.isilsubasi.quizapp.util.PrefUtil;

public class LoginActivity extends AppCompatActivity {


    EditText editName;
    Button btnIleri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editName=findViewById(R.id.edtName);
        btnIleri=findViewById(R.id.btnIleri);

        //İleri butonuna tıklanınca çalışan metot.
        btnIleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Edittexte yazılan yazının boş olup olmadığını kontrol ederek ,
                //Eğer boş değilse SharedPreferencese kaydederek yani locale kaydederek diğer aktivitede kullanabilir.
                String oyuncuAdi=editName.getText().toString();
                if (oyuncuAdi.isEmpty()){
                    Toast.makeText(getApplicationContext(), " Lütfen Boş Bırakmayınız..", Toast.LENGTH_SHORT).show();
                }else{
                    PrefUtil.setStringPref(getApplicationContext(), Constans.PREF_OYUNCU_ADI_PARAMETRESİ,oyuncuAdi);
                    Intent intent=new Intent(getApplicationContext(), CategoryActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }




}