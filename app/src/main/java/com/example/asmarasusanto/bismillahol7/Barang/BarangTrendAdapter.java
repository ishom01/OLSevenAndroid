package com.example.asmarasusanto.bismillahol7.Barang;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.asmarasusanto.bismillahol7.BarangListActivity;
import com.example.asmarasusanto.bismillahol7.DetailBarangActivity;
import com.example.asmarasusanto.bismillahol7.ItemClickListener;
import com.example.asmarasusanto.bismillahol7.MainActivity;
import com.example.asmarasusanto.bismillahol7.R;
import com.example.asmarasusanto.bismillahol7.Setting.AppController;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by asmarasusanto on 5/17/17.
 */

public class BarangTrendAdapter extends RecyclerView.Adapter<BarangTrendAdapter.ViewHolder>{

    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    private List<BarangTrend> mDataset;
    private String url,id;
    private Context context;

    public BarangTrendAdapter(Context context, ArrayList<BarangTrend> mDataset) {
        this.context = context;
        this.mDataset = mDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_trend_barang, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
//        holder.bind(mDataset.get(position),listener);
        holder.namabarangView.setText("#"+mDataset.get(position).getKeySearch());
        holder.namaToko.setText("Jumlah Barang : "+mDataset.get(position).getJumlah());
        holder.thumbnail.setImageUrl(mDataset.get(position).getUrlFoto(), imageLoader);


        id = mDataset.get(position).getId();
        url = mDataset.get(position).getKeySearch();

//        holder.setClickListener(new ItemClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                Toast.makeText(context, mDataset.get(position).getId()+" , " + mDataset.get(position).getKeySearch(), Toast.LENGTH_LONG).show();
//            }
//        });
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView namabarangView, namaToko;
        public NetworkImageView thumbnail;
        public Context cont;

        private ItemClickListener clickListener;


        public ViewHolder(View itemView) {
            super(itemView);
            namabarangView = (TextView) itemView.findViewById(R.id.namaHashtag);
            namaToko = (TextView) itemView.findViewById(R.id.jumlahBarang);
            thumbnail = (NetworkImageView) itemView.findViewById(R.id.gambarbarang);
            final Context asd = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(asd, BarangListActivity.class);
//                    Toast.makeText(context,mDataset.get(getPosition()).getKeySearch()+ " , " + mDataset.get(getPosition()).getKeySearch(),Toast.LENGTH_LONG).show();
                    intent.putExtra("key", mDataset.get(getPosition()).getKeySearch());
//                    intent.putExtra("key", url);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}
