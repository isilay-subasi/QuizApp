package com.isilsubasi.quizapp.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.util.ActivityUtils;
import com.isilsubasi.quizapp.util.AlertUtils;
import com.isilsubasi.quizapp.util.Constans;
import com.isilsubasi.quizapp.util.PrefUtil;

public class CategoryActivity extends AppCompatActivity{

    TextView txtUserName,txtAndroid,txtJava;
    CardView cardAndroid,cardJava,cardExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initUI();

    }


private void initUI(){
    txtUserName =findViewById(R.id.txtUserName);
    txtAndroid =findViewById(R.id.tv_android);
    txtJava =findViewById(R.id.tv_java);
    cardAndroid=findViewById(R.id.cardAndroid);
    cardJava=findViewById(R.id.cardJava);
    cardExit =findViewById(R.id.cardCikis);
    txtUserName.setText(PrefUtil.getStringPref(getApplicationContext(), Constans.PREF_OYUNCU_ADI_PARAMETRESİ));
    setClickListeners();

}


private void setClickListeners(){

    cardAndroid.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ActivityUtils.openGameActivity(CategoryActivity.this,GameActivity.class,txtAndroid,cardAndroid);
        }
    });


    cardJava.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ActivityUtils.openGameActivity(CategoryActivity.this,GameActivity.class,txtJava,cardJava);
        }
    });



    cardExit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertUtils.showExitUtil(CategoryActivity.this);
        }
    });

}

}