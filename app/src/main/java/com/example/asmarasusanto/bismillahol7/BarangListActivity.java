package com.example.asmarasusanto.bismillahol7;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.asmarasusanto.bismillahol7.Barang.Barang;
import com.example.asmarasusanto.bismillahol7.Barang.BarangAdapter2;
import com.example.asmarasusanto.bismillahol7.Barang.BarangTrend;
import com.example.asmarasusanto.bismillahol7.Barang.BarangTrendAdapter;
import com.example.asmarasusanto.bismillahol7.Retro.APIInterface;
import com.example.asmarasusanto.bismillahol7.Retro.ApiClient;
import com.example.asmarasusanto.bismillahol7.Retro.ListTBarangFromKey;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import retrofit2.Call;

public class BarangListActivity extends AppCompatActivity {

    Toolbar toolbar;
    MaterialSearchView searchView;
    GridView gridView;
    private ArrayList<Barang> listBarang = new ArrayList<>();

    private APIInterface apiInterface;
    private BarangAdapter2 barangAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang_list);

        apiInterface = ApiClient.bukalapakAPI().create(APIInterface.class);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

        gridView = (GridView) findViewById(R.id.profile_photos_grid);
        barangAdapter = new BarangAdapter2(getApplicationContext(),this, listBarang);

        gridView.setAdapter(barangAdapter);

        Intent mIntent = getIntent();
        Bundle bundle = mIntent.getExtras();

        final String key_url = bundle.getString("key");

        searchView = (MaterialSearchView) findViewById(R.id.searchView);

        Call call = apiInterface.doGetListBarangFromKey(true, key_url);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()){
                    ListTBarangFromKey resource = (ListTBarangFromKey) response.body();
                    List<ListTBarangFromKey.Product> datum = resource.data;
                    for (ListTBarangFromKey.Product data : datum ){
                        if (Integer.parseInt(data.feeBarang) > 200){
                            Barang barang = new Barang();
                            barang.setNamaBarang(data.nameBarang);
                            barang.setHargaBarang(data.priceBarang);
                            barang.setId(data.idBarnag);
                            barang.setTokoBarang(data.sellerBarang);
                            barang.setFeeBarang(data.feeBarang);
                            barang.setUrlFoto(data.small_images.get(0));
                            listBarang.add(barang);
                        }
                    }
                }
                barangAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
//                    new Se().aturDialog(LoginActivity.this, .message);
                call.cancel();
            }
        });
    }
}
