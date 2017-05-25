package com.example.asmarasusanto.bismillahol7;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asmarasusanto.bismillahol7.Barang.Barang;
import com.example.asmarasusanto.bismillahol7.Chart.Chart;
import com.example.asmarasusanto.bismillahol7.Chart.ChartAdapter;
import com.example.asmarasusanto.bismillahol7.Database.AksesLogin;
import com.example.asmarasusanto.bismillahol7.Database.SQLiteHandler;
import com.example.asmarasusanto.bismillahol7.Retro.APIInterface;
import com.example.asmarasusanto.bismillahol7.Retro.ApiClient;
import com.example.asmarasusanto.bismillahol7.Retro.ListTBarangFromKey;
import com.example.asmarasusanto.bismillahol7.Retro.ResponseChart;
import com.example.asmarasusanto.bismillahol7.Trend.Trend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartActivity extends AppCompatActivity {

    private ListView listViewChart;
    private TextView totalHargaBarang, totalHargaKirim, totalHargaSemua, setAlamat;
    private Button btnMbayar;

    private APIInterface apiInterface;
    private ArrayList<Trend> listChart = new ArrayList<>();

    private SQLiteHandler db;
    private AksesLogin aksesLogin;

    String hargaBarang, hargaKirim, hargaKeseluruhan;

    private ChartAdapter chartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        apiInterface = ApiClient.bukalapakAPI().create(APIInterface.class);

        Intent mIntent = getIntent();
        Bundle bundle = mIntent.getExtras();

        final String id = bundle.getString("id");

        //setting cache
        db = new SQLiteHandler(getApplicationContext());
        aksesLogin = new AksesLogin(db);

        HashMap<String, String> data = aksesLogin.getUserData();

        String iduser = data.get("user_id");
        String token = data.get("token");

        String tokenAuth = "Basic " + Base64.encodeToString(String.format("%s:%s", iduser, token).getBytes(), Base64.NO_WRAP);


        totalHargaBarang = (TextView) findViewById(R.id.txtHargaItem);
        totalHargaKirim = (TextView) findViewById(R.id.txtHargaKirim);
        totalHargaSemua = (TextView) findViewById(R.id.txtHargaTotal);
        setAlamat = (TextView) findViewById(R.id.txtSettingAdd);

        btnMbayar = (Button) findViewById(R.id.btnMbayar);

        listViewChart = (ListView) findViewById(R.id.listBarang);

        Call call = apiInterface.postChart(id,tokenAuth,"1");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()){
                    ResponseChart resource = (ResponseChart) response.body();
                    List <ResponseChart.Cart> cart = resource.chart;
                    chartAdapter = new ChartAdapter(getApplicationContext(), ChartActivity.this, cart);
                    listViewChart.setAdapter(chartAdapter);
                }
                chartAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
//                    new Se().aturDialog(LoginActivity.this, .message);
                call.cancel();
            }
        });
    }
}
