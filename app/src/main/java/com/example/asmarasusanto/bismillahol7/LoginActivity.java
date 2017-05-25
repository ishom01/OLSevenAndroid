package com.example.asmarasusanto.bismillahol7;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asmarasusanto.bismillahol7.Barang.Barang;
import com.example.asmarasusanto.bismillahol7.Database.AksesLogin;
import com.example.asmarasusanto.bismillahol7.Database.AksesTrend;
import com.example.asmarasusanto.bismillahol7.Database.SQLiteHandler;
import com.example.asmarasusanto.bismillahol7.Dialog.SettingDialog;
import com.example.asmarasusanto.bismillahol7.Retro.APIInterface;
import com.example.asmarasusanto.bismillahol7.Retro.ApiClient;
import com.example.asmarasusanto.bismillahol7.Retro.ListTBarangFromKey;
import com.example.asmarasusanto.bismillahol7.Retro.TrendList;
import com.example.asmarasusanto.bismillahol7.Retro.UserDetail;
import com.example.asmarasusanto.bismillahol7.Trend.Trend;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Callback;


public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnLogin;

    String username, password;

    private APIInterface apiInterface;
    private APIInterface apiGetTrend;

    private SQLiteHandler db;
    private AksesLogin aksesLogin;
    private AksesTrend aksesTrend;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        apiInterface = ApiClient.bukalapakAPI().create(APIInterface.class);
        apiGetTrend = ApiClient.getTwitterTrend().create(APIInterface.class);

        db = new SQLiteHandler(getApplicationContext());
        aksesLogin = new AksesLogin(db);
        aksesTrend = new AksesTrend(db);

        aksesTrend.deleteListTrend();
        aksesLogin.deleteUserLogin();

        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Loading Data..");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setIndeterminate(true);
        progressDialog.show();

        retrofit2.Call call2 = apiGetTrend.getTrendList("23424846");
        call2.enqueue(new Callback() {
            @Override
            public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                ArrayList<TrendList> data = (ArrayList<TrendList>) response.body();
                TrendList resource = (TrendList) data.get(0);
                List<TrendList.Trend> datum = resource.status;

                for (TrendList.Trend ambiil : datum){
                    if (ambiil.twetVolume !=  null){
                        String search = ambiil.namaTwet.replace("#", "");
                        aksesTrend.addTrend(ambiil.namaTwet, search);
                    }
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {
                call.cancel();
            }
        });


        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        btnLogin = (Button) findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = edtUsername.getText().toString();
                password = edtPassword.getText().toString();

                String basicAuth = "Basic " + Base64.encodeToString(String.format("%s:%s", username, password).getBytes(), Base64.NO_WRAP);

                if (!username.isEmpty() && !password.isEmpty()){
                    retrofit2.Call call = apiInterface.createUser(basicAuth);
                    call.enqueue(new Callback() {
                        @Override
                        public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                            UserDetail resource = (UserDetail) response.body();
                            if (Objects.equals(resource.status, "OK")){
                                aksesLogin.addUserLogin(resource.idUser, resource.nameUser, resource.tokenUser, resource.emailUser, resource.omniUser);
                                db.close();

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);

                            }else {
                                new SettingDialog().aturDialog(LoginActivity.this, resource.message);
                            }
                        }

                        @Override
                        public void onFailure(retrofit2.Call call, Throwable t) {
                            call.cancel();
                        }
                    });
                }else {
                    new SettingDialog().aturDialog(LoginActivity.this, "pastikan username dan password tidak kosong ");
                }
            }
        });
    }
}
