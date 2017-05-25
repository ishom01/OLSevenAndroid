package com.example.asmarasusanto.bismillahol7.Barang;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.asmarasusanto.bismillahol7.BarangListActivity;
import com.example.asmarasusanto.bismillahol7.Chart.ItemAdapter;
import com.example.asmarasusanto.bismillahol7.DetailBarangActivity;
import com.example.asmarasusanto.bismillahol7.R;
import com.example.asmarasusanto.bismillahol7.Retro.ResponseChart;
import com.example.asmarasusanto.bismillahol7.Setting.AppController;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by asmarasusanto on 5/24/17.
 */

public class BarangAdapter2 extends BaseAdapter {

    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    private final Activity activity;
    private final List<Barang> chartItem;
    private LayoutInflater inflater;
    private Context context;

    private ItemAdapter itemAdapter;

    public BarangAdapter2(Context cont, Activity activity, List<Barang> chartItem) {
        context = cont;
        this.activity = activity;
        this.chartItem = chartItem;
    }

    @Override
    public int getCount() {
        return chartItem.size();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_barang, null);
        }
        TextView namabarangView = (TextView) convertView.findViewById(R.id.namabarang);
        TextView namaToko = (TextView) convertView.findViewById(R.id.namaToko);
        TextView feedBack = (TextView) convertView.findViewById(R.id.feedBack);
        TextView hargabarangView = (TextView) convertView.findViewById(R.id.hargabarang);
        NetworkImageView thumbnail = (NetworkImageView) convertView.findViewById(R.id.gambarbarang);

        final Barang cart = chartItem.get(position);

        namabarangView.setText(cart.getNamaBarang());
        thumbnail.setImageUrl(cart.getUrlFoto(), imageLoader);
        namaToko.setText(cart.getTokoBarang());
        hargabarangView.setText("Rp. " + NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(cart.getHargaBarang())));
        feedBack.setText("feedback : " + cart.getFeeBarang());

        final Context cont = convertView.getContext();
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cont, DetailBarangActivity.class);
//                    Toast.makeText(context,mDataset.get(getPosition()).getKeySearch()+ " , " + mDataset.get(getPosition()).getKeySearch(),Toast.LENGTH_LONG).show();
                intent.putExtra("id", cart.getId());
//                    intent.putExtra("key", url);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}