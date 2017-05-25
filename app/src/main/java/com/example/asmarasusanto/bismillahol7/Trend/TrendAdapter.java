package com.example.asmarasusanto.bismillahol7.Trend;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asmarasusanto.bismillahol7.R;

import java.util.ArrayList;

/**
 * Created by asmarasusanto on 5/16/17.
 */

public class TrendAdapter extends RecyclerView.Adapter<TrendAdapter.ViewHolder>{

    private ArrayList<Trend> mDataset;

    public TrendAdapter(ArrayList<Trend> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.twit, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.namaHashTag.setText(mDataset.get(position).getKeyTrend());

    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView namaHashTag;

        public ViewHolder(View itemView) {
            super(itemView);
            namaHashTag = (TextView) itemView.findViewById(R.id.hasTag);
        }
    }
}