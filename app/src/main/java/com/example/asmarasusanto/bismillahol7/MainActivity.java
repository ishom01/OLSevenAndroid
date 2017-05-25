package com.example.asmarasusanto.bismillahol7;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.asmarasusanto.bismillahol7.Barang.BarangTrend;
import com.example.asmarasusanto.bismillahol7.Barang.BarangTrendAdapter;
import com.example.asmarasusanto.bismillahol7.Database.AksesTrend;
import com.example.asmarasusanto.bismillahol7.Database.SQLiteHandler;
import com.example.asmarasusanto.bismillahol7.Retro.APIInterface;
import com.example.asmarasusanto.bismillahol7.Retro.ApiClient;
import com.example.asmarasusanto.bismillahol7.Retro.ListTBarangFromKey;
import com.example.asmarasusanto.bismillahol7.Trend.Trend;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //recycle Barang
    private RecyclerView recyclerViewBarang;
    private RecyclerView.LayoutManager mLayoutBarangManager;
    private RecyclerView.Adapter barangAdapter;
    private ArrayList<BarangTrend> listBarang = new ArrayList<>();

    //recycle Trend
    private RecyclerView recyclerViewTrend;
    private RecyclerView.LayoutManager mLayoutTrendManager;
    private RecyclerView.Adapter trendAdapter;
    private ArrayList<Trend> listTrend = new ArrayList<>();

    private APIInterface apiInterface;
    private APIInterface apiGetTrend;

    private SQLiteHandler db;
    private AksesTrend aksesTrend;

    private ArrayList<Call> callLIst = new ArrayList<>();
    private ArrayList<String> keyList = new ArrayList<>();
    private String key;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.bukalapakAPI().create(APIInterface.class);
        apiGetTrend = ApiClient.getTwitterTrend().create(APIInterface.class);

        db = new SQLiteHandler(getApplicationContext());
        aksesTrend = new AksesTrend(db);

        //recycle
        recyclerViewBarang = (RecyclerView) findViewById(R.id.recycleBarang);

        //Barang
        recyclerViewBarang.setHasFixedSize(true);
        mLayoutBarangManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewBarang.setLayoutManager(mLayoutBarangManager);
        barangAdapter = new BarangTrendAdapter(getApplicationContext(), listBarang);
        recyclerViewBarang.setAdapter(barangAdapter);


        final Cursor data2 = aksesTrend.getListTrend();

        while (data2.moveToNext()){
            Trend trend = new Trend(data2.getString(1),data2.getString(2));
            listTrend.add(trend);

            key = data2.getString(2);
//            Log.i("MainActivity Test", "iterate data2");
            callLIst.add(apiInterface.doGetListBarangFromKey(true, key));
            keyList.add(key);
//            call.enqueue(new Callback() {
//                @Override
//                public void onResponse(Call call, Response response) {
////                    Log.i("MainActivity Test", "onResponse");
//                    if (response.isSuccessful()){
//                        ListTBarangFromKey resource = (ListTBarangFromKey) response.body();
//                        List<ListTBarangFromKey.Product> datum = resource.data;
//                        for (ListTBarangFromKey.Product data : datum ){
//                            if (Integer.parseInt(data.feeBarang) > 1000){
//                                BarangTrend barang = new BarangTrend();
//                                barang.setKeySearch(key);
//                                barang.setJumlah("" + datum.size());
//                                barang.setUrlFoto(data.small_images.get(0));
//                                listBarang.add(barang);
//                                break;
//                            }
//                        }
//                    }
//                    barangAdapter.notifyDataSetChanged();
//                }
//
//                @Override
//                public void onFailure(Call call, Throwable t) {
////                    new Se().aturDialog(LoginActivity.this, .message);
//                    call.cancel();
//                }
//            });

//            Call call = apiInterface.doGetListBarangFromKey(true, key);
//            call.enqueue(new Callback() {
//                @Override
//                public void onResponse(Call call, Response response) {
//                    if (response.isSuccessful()){
//                        ListTBarangFromKey resource = (ListTBarangFromKey) response.body();
//                        List<ListTBarangFromKey.Product> datum = resource.data;
//                        int i = 0;
//                        for (ListTBarangFromKey.Product data : datum ){
//                            i++;
//                            if (Integer.parseInt(data.feeBarang) > 200){
//                                Barang barang = new Barang();
//                                barang.setNamaBarang(data.nameBarang);
//                                barang.setKeySearch(key);
//                                barang.setHargaBarang(data.priceBarang);
//                                barang.setId(data.idBarnag);
//                                barang.setTokoBarang(data.sellerBarang);
//                                barang.setFeeBarang(data.feeBarang);
//                                barang.setUrlFoto(data.small_images.get(0));
//                                listBarang.add(barang);
//                            }
//
//                            if (i < 3 ){
//                                i = 0;
//                                break;
//                            }
//                        }
//                    }
//                    barangAdapter.notifyDataSetChanged();
//                }
//
//                @Override
//                public void onFailure(Call call, Throwable t) {
////                    new Se().aturDialog(LoginActivity.this, .message);
//                    call.cancel();
//                }
//            });
        }

//        retrofit2.Call call2 = apiGetTrend.getTrendList("23424846");
//        call2.enqueue(new Callback() {
//            @Override
//            public void onResponse(retrofit2.Call call, retrofit2.Response response) {
//                ArrayList<TrendList> data = (ArrayList<TrendList>) response.body();
//                TrendList resource = (TrendList) data.get(0);
//                List<TrendList.Trend> datum = resource.status;
//
//                for (TrendList.Trend ambiil : datum){
//                    if (ambiil.twetVolume !=  null){
//                        String search = ambiil.namaTwet.replace("#", "");
//                        Trend trend = new Trend(ambiil.namaTwet, search);
//                        listTrend.add(trend);
//                    }
//                }
//                trendAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call call, Throwable t) {
//                call.cancel();
//            }
//        });


//        retrofit2.Call call = apiInterface.doGetListBarangFromKey(true, "martabak");
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(retrofit2.Call call, retrofit2.Response response) {
//                ListTBarangFromKey resource = (ListTBarangFromKey) response.body();
//                List<ListTBarangFromKey.Product> datum = resource.data;
//
//                for (ListTBarangFromKey.Product data : datum){
//                    Barang barang = new Barang();
//                    barang.setNamaBarang(data.nameBarang);
//                    barang.setHargaBarang(data.priceBarang);
//                    barang.setId(data.idBarnag);
//                    barang.setTokoBarang(data.sellerBarang);
//                    barang.setFeeBarang(data.feeBarang);
//                    barang.setUrlFoto(data.small_images.get(0));
//                    listBarang.add(barang);
//                }
//
//                barangAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call call, Throwable t) {
//                call.cancel();
//            }
//        });
        Log.i("CallList size: ", String.valueOf(callLIst.size()));
        Log.i("KeyList size: ", String.valueOf(keyList.size()));
        Log.i("Key: ", keyList.get(keyList.size()-1));

        useCallBack();

    }

    private void useCallBack() {
        callLIst.get(i).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
//                    Log.i("MainActivity Test", "onResponse");
                Log.i("iterate i callList: ", String.valueOf(i));

                if (response.isSuccessful()){

                    ListTBarangFromKey resource = (ListTBarangFromKey) response.body();
                    List<ListTBarangFromKey.Product> datum = resource.data;
                    for (ListTBarangFromKey.Product data : datum ){
                        if (Integer.parseInt(data.feeBarang) > 1000){
                            BarangTrend barang = new BarangTrend();
                            barang.setKeySearch(keyList.get(i));
                            barang.setJumlah("" + datum.size());
                            barang.setUrlFoto(data.small_images.get(0));
                            listBarang.add(barang);
                            break;
                        }
                    }
                }
                barangAdapter.notifyDataSetChanged();
                i++;
                if (i < keyList.size()){
                    useCallBack();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
//                    new Se().aturDialog(LoginActivity.this, .message);
                call.cancel();
            }
        });
    }
}
