package com.isilsubasi.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.util.ActivityUtils;
import com.isilsubasi.quizapp.util.Constans;
import com.isilsubasi.quizapp.util.PrefUtil;

public class LoginActivity extends AppCompatActivity {

    EditText editUserName;
    Button btnSaveUserName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
    }

    private void initUI(){
    editUserName =findViewById(R.id.edtName);
    btnSaveUserName =findViewById(R.id.btnIleri);
    setClickListeners();

    }

    private void setClickListeners(){
    //İleri butonuna tıklanınca çalışan metot.
    btnSaveUserName.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                saveUserName();
        }
    });

    }


    private void saveUserName(){
    //Edittexte yazılan yazının boş olup olmadığını kontrol ederek ,
    //Eğer boş değilse SharedPreferencese kaydederek yani locale kaydederek diğer aktivitede kullanabilir.
    String userName= editUserName.getText().toString();
    if (userName.isEmpty()){
        Toast.makeText(getApplicationContext(),getString(R.string.toast_not_empty), Toast.LENGTH_SHORT).show();
    }else{
        PrefUtil.setStringPref(getApplicationContext(), Constans.PREF_USER_NAME_PARAMETER,userName);
        ActivityUtils.openScreen(this,CategoryActivity.class,true);
    }

    }

}