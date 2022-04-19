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
import com.isilsubasi.quizapp.util.Constans;
import com.isilsubasi.quizapp.util.PrefUtil;

public class CategoryActivity extends AppCompatActivity{

    TextView tvCategory;
    TextView tvAndroid;
    CardView cardAndroid;
    CardView cardJava;
    CardView cardCikis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initThis();
        tvCategory.setText(PrefUtil.getStringPref(getApplicationContext(), Constans.PREF_OYUNCU_ADI_PARAMETRESİ));
        cardAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),GameActivity.class);
                intent.putExtra(Constans.GAME_BAR_PARAMETRESI,tvAndroid.getText().toString());
                startActivity(intent);
            }
        });


        cardJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        cardCikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CategoryActivity.this);
                builder.setTitle("Çıkış");
                builder.setMessage("Uygulamadan Çıkılsın Mı ?");
                builder.setNegativeButton("Hayır",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }

                );
                builder.setPositiveButton("Evet", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish();
                            }
                        });

                builder.show();


            }
        });



    }


public void initThis(){
    tvCategory=findViewById(R.id.tvCategory);
    tvAndroid=findViewById(R.id.tv_android);
    cardAndroid=findViewById(R.id.cardAndroid);
    cardJava=findViewById(R.id.cardJava);
    cardCikis=findViewById(R.id.cardCikis);

}




}