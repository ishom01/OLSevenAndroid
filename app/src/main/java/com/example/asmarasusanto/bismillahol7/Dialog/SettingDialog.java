package com.example.asmarasusanto.bismillahol7.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.asmarasusanto.bismillahol7.R;

/**
 * Created by asmarasusanto on 5/18/17.
 */

public class SettingDialog {

    public SettingDialog aturDialog(Context cont, String message){
        final Dialog dialog = new Dialog(cont);
        dialog.setContentView(R.layout.dialgo);

        TextView pesan = (TextView)dialog.findViewById(R.id.message);
        Button end = (Button)dialog.findViewById(R.id.btn);

        pesan.setText(message);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

        return  null;
    }
}
