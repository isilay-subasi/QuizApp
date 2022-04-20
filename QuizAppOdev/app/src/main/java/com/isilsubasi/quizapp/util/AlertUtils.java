package com.isilsubasi.quizapp.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.isilsubasi.quizapp.R;
import com.isilsubasi.quizapp.activities.CategoryActivity;

public class AlertUtils {


    public static void showExitUtil(Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(activity.getString(R.string.alert_title_exit));
        builder.setMessage(activity.getString(R.string.alert_message_exit));
        builder.setNegativeButton(activity.getString(R.string.alert_negative_button),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }
        );
        builder.setPositiveButton(activity.getString(R.string.alert_positive_button), new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                       activity.finish();
                    }
                });
        builder.show();
    }
}



