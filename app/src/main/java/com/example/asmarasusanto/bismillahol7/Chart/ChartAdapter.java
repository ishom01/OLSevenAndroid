package com.example.asmarasusanto.bismillahol7.Chart;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asmarasusanto.bismillahol7.R;
import com.example.asmarasusanto.bismillahol7.Retro.ResponseChart;
import com.example.asmarasusanto.bismillahol7.Trend.TrendAdapter;

import java.util.List;

/**
 * Created by asmarasusanto on 5/24/17.
 */

public class ChartAdapter extends BaseAdapter {

    private final Activity activity;
    private final List<ResponseChart.Cart> chartItem;
    private LayoutInflater inflater;
    private Context context;

    private ItemAdapter itemAdapter;

    public ChartAdapter(Context cont, Activity activity, List<ResponseChart.Cart> chartItem) {
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
            convertView = inflater.inflate(R.layout.list_chart, null);
        }

        TextView namaToko= (TextView) convertView.findViewById(R.id.txtNamaToko);
        ListView recyclerViewItem = (ListView) convertView.findViewById(R.id.listItem);

        ResponseChart.Cart cart = chartItem.get(position);

        namaToko.setText(cart.seller.nameSeller);

//        recyclerViewItem.setHasFixedSize(true);
//        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
//        recyclerViewItem.setLayoutManager(mLayoutManager);

        itemAdapter = new ItemAdapter(context, cart.itemChart);
        recyclerViewItem.setAdapter(itemAdapter);

        return convertView;
    }
}