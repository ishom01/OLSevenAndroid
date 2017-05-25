package com.example.asmarasusanto.bismillahol7;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.asmarasusanto.bismillahol7.Barang.ImageAdapter;
import com.example.asmarasusanto.bismillahol7.Database.AksesLogin;
import com.example.asmarasusanto.bismillahol7.Database.SQLiteHandler;
import com.example.asmarasusanto.bismillahol7.Dialog.CekInternetDialog;
import com.example.asmarasusanto.bismillahol7.Dialog.SettingDialog;
import com.example.asmarasusanto.bismillahol7.Dialog.SettingLoadingDialog;
import com.example.asmarasusanto.bismillahol7.Retro.APIInterface;
import com.example.asmarasusanto.bismillahol7.Retro.ApiClient;
import com.example.asmarasusanto.bismillahol7.Retro.DetailBarang;
import com.example.asmarasusanto.bismillahol7.Setting.AppController;
import com.example.asmarasusanto.bismillahol7.Trend.Trend;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;

public class DetailBarangActivity extends AppCompatActivity {

    ViewPager imagePager;
    TextView namaBarang, ulasanBarang, hargaBarang, stokBarang, terjualBarang, peminatBarang, dilihatBarang, namaSeller, deskripasi, lokasiToko;
    RatingBar ratingBarang;
    LinearLayout btnTambah;

    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    NetworkImageView sellerApatar;

    private APIInterface apiInterface;

    private SQLiteHandler db;
    private AksesLogin aksesLogin;

    private ArrayList<Trend> listTrend = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);

        Intent mIntent = getIntent();
        Bundle bundle = mIntent.getExtras();

        final String id = bundle.getString("id");
//        String key = bundle.getString("key");

//        db = new SQLiteHandler(getApplicationContext());
//        aksesLogin = new AksesLogin(db);

//        HashMap<String, String> login = aksesLogin.getUserData();

//        Toast.makeText(getApplicationContext(), login.get("user_id"), Toast.LENGTH_LONG).show();

        apiInterface= ApiClient.bukalapakAPI().create(APIInterface.class);

        imagePager = (ViewPager) findViewById(R.id.imgPager);

        namaBarang = (TextView) this.findViewById(R.id.namaBarang);
        ulasanBarang = (TextView) findViewById(R.id.txtStar);
        hargaBarang = (TextView) findViewById(R.id.hargaBarang);
        stokBarang = (TextView) findViewById(R.id.txtStok);
        lokasiToko = (TextView) findViewById(R.id.lokasiToko);
        terjualBarang = (TextView) findViewById(R.id.trxtTerjual);
        deskripasi = (TextView) findViewById(R.id.txtDeskripsi);
        peminatBarang = (TextView) findViewById(R.id.txtPeminat);
        dilihatBarang = (TextView) findViewById(R.id.textDilihat);
        namaSeller = (TextView) findViewById(R.id.namaToko);

        btnTambah = (LinearLayout)findViewById(R.id.btnTumbas);

        ratingBarang = (RatingBar)findViewById(R.id.ratingBar2);

        Call<DetailBarang> call = apiInterface.getDetailBarang("application/json", id);
        call.enqueue(new Callback<DetailBarang>() {
            @Override
            public void onResponse(retrofit2.Call<DetailBarang> call, retrofit2.Response<DetailBarang> response) {
                if (response.isSuccessful()){
                    DetailBarang resource = response.body();

                    ImageAdapter pagerImage = new ImageAdapter(DetailBarangActivity.this, resource.data.small_images);
                    imagePager.setAdapter(pagerImage);

                    namaBarang.setText(resource.data.nameBarang);
                    ratingBarang.setRating(Float.parseFloat(resource.data.rating.ratingAngka));
                    ulasanBarang.setText("("+ resource.data.rating.ratingAngka + ")");
                    hargaBarang.setText("Rp. " + NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(resource.data.priceBarang)));
                    stokBarang.setText(resource.data.stockBarang);
                    terjualBarang.setText(resource.data.soldBarang);
                    peminatBarang.setText(resource.data.interesBarang);
                    dilihatBarang.setText(resource.data.viewBarang);
                    namaSeller.setText(resource.data.sellerBarang);
                    lokasiToko.setText(resource.data.cityBarang);
                    deskripasi.setText(Html.fromHtml(resource.data.deskripsi));

                }else{
                    new CekInternetDialog().aturDialog(DetailBarangActivity.this, "Kuotamu kurang Larang, tukuo perdana SEMPATIN", id);
                }
            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {
                call.cancel();
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailBarangActivity.this, ChartActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

    }
}
