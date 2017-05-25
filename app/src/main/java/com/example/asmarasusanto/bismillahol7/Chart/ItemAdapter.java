package com.example.asmarasusanto.bismillahol7.Chart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.asmarasusanto.bismillahol7.R;
import com.example.asmarasusanto.bismillahol7.Retro.ResponseChart;
import com.example.asmarasusanto.bismillahol7.Setting.AppController;

import java.util.List;

/**
 * Created by asmarasusanto on 5/24/17.
 */

//public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
public class ItemAdapter extends BaseAdapter {

//    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();
//
//    private List<ResponseChart.Barang> mDataset;
//    private Context context;
//
//    public ItemAdapter(Context context, List<ResponseChart.Barang> mDataset) {
//        this.context = context;
//        this.mDataset = mDataset;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        // create a new view
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(final ViewHolder holder, int position) {
//
//        holder.namaItem.setText(mDataset.get(position).nameProduct);
//        holder.jmlhPesan.setText(mDataset.get(position).qtyProduct);
//        holder.txtHargaItem.setText("Rp. " + NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(mDataset.get(position).priceProduct)));
//        holder.thumbnail.setImageUrl(mDataset.get(position).small_product.get(0), imageLoader);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, mDataset.get(position).courierProduct);
//        holder.spin.setAdapter(adapter);
//
//    }
//    @Override
//    public int getItemCount() {
//        return mDataset.size();
//    }
//
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//
//        public TextView namaItem;
//        public TextView jmlhPesan;
//        public TextView txtHargaItem;
//        public NetworkImageView thumbnail;
//        public Spinner spin;
//        public Context cont;
//
//        private ItemClickListener clickListener;
//
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//
//            namaItem = (TextView) itemView.findViewById(R.id.txtNamaItem);
//            jmlhPesan = (TextView) itemView.findViewById(R.id.txtPesan);
//            txtHargaItem = (TextView) itemView.findViewById(R.id.txtHargaItem);
//            thumbnail = (NetworkImageView) itemView.findViewById(R.id.imgItem);
//            spin = (Spinner) itemView.findViewById(R.id.spinKirim);
//
//            final Context asd = itemView.getContext();
////            itemView.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    Intent intent = new Intent(asd, DetailBarangActivity.class);
//////                    Toast.makeText(context,mDataset.get(getPosition()).getId()+ " , " + mDataset.get(getPosition()).getKeySearch(),Toast.LENGTH_LONG).show();
////                    intent.putExtra("id", mDataset.get(getPosition()).getId());
//////                    intent.putExtra("key", url);
////                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                    context.startActivity(intent);
////                }
////            });
//        }
//    }

    //end

    private final Context context;
    private final List<ResponseChart.Barang> barangItem;
    private LayoutInflater inflater;
    private String compareValue = "Pilih kode pembayaran";

    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();

//    private ItemAdapter itemAdapter;

    public ItemAdapter(Context context, List<ResponseChart.Barang> barangItem) {
        this.context = context;
        this.barangItem = barangItem;
    }

    @Override
    public int getCount() {
        return barangItem.size();
    }

    @Override
    public Object getItem(int i) {
        return getItem(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_semua, null);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_barang, parent, false);


        TextView namaItem = (TextView) convertView.findViewById(R.id.txtNamaBarang);
        TextView jmlhPesan = (TextView) convertView.findViewById(R.id.txtQtyBarang);
        TextView txtHargaItem = (TextView) convertView.findViewById(R.id.txtHargaBarang);
        NetworkImageView thumbnail = (NetworkImageView) convertView.findViewById(R.id.imgBarang);
//        Spinner spin = (Spinner) convertView.findViewById(R.id.spinKirim);

        ResponseChart.Barang barang = barangItem.get(position);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, barang.courierProduct);
//        spin.setAdapter(adapter);

        namaItem.setText(barang.nameProduct);
        jmlhPesan.setText(barang.qtyProduct);
        txtHargaItem.setText(barang.priceProduct);

//        thumbnail.setImageUrl(barang.small_product.get(0), imageLoader);

        return convertView;
    }

    public class ViewHolder {
    }

}
