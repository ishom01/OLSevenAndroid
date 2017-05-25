package com.example.asmarasusanto.bismillahol7.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.asmarasusanto.bismillahol7.MainActivity;
import com.example.asmarasusanto.bismillahol7.R;

/**
 * Created by asmarasusanto on 5/18/17.
 */

public class CekInternetDialog {

    public CekInternetDialog aturDialog(final Activity activityIni, String message, final String id){
        final Dialog dialog = new Dialog(activityIni);
        dialog.setContentView(R.layout.progres_dialog);

        TextView pesan = (TextView)dialog.findViewById(R.id.message);
        Button retry = (Button)dialog.findViewById(R.id.btnRetry);

        pesan.setText(message);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context cont = v.getContext();
                Intent intent = new Intent(cont, activityIni.getClass());
                intent.putExtra("id", id);
                dialog.dismiss();
                cont.startActivity(intent);
            }
        });

        dialog.show();

        return  null;
    }
}
