package com.isilsubasi.quizapp.activities;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.util.ActivityUtils;
import com.isilsubasi.quizapp.util.AlertUtils;
import com.isilsubasi.quizapp.util.Constans;
import com.isilsubasi.quizapp.util.PrefUtil;

import java.util.HashMap;

public class CategoryActivity extends AppCompatActivity{

    TextView txtUserName,txtAndroid,txtJava;
    CardView cardAndroid,cardJava,cardExit;
    HashMap<String,String> HashMap=new HashMap<>();


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
    txtUserName.setText(PrefUtil.getStringPref(getApplicationContext(), Constans.PREF_USER_NAME_PARAMETER));
    setClickListeners();

}


private void setClickListeners(){

    cardAndroid.setOnClickListener(new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View view) {
            HashMap.put(Constans.GAME_BAR_PARAMETER,txtAndroid.getText().toString());
            HashMap.put(Constans.GAME_BAR_COLOR, String.valueOf(cardAndroid.getCardBackgroundColor().getDefaultColor()));
            ActivityUtils.openActivityWithParams(CategoryActivity.this,GameActivity.class, HashMap);
        }
    });


    cardJava.setOnClickListener(new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View view) {
            HashMap.put(Constans.GAME_BAR_PARAMETER,txtJava.getText().toString());
            HashMap.put(Constans.GAME_BAR_COLOR, String.valueOf(cardJava.getCardBackgroundColor().getDefaultColor()));
            ActivityUtils.openActivityWithParams(CategoryActivity.this,GameActivity.class, HashMap);
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