package com.example.asmarasusanto.bismillahol7.Barang;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.asmarasusanto.bismillahol7.R;
import com.example.asmarasusanto.bismillahol7.Retro.DetailBarang;
import com.example.asmarasusanto.bismillahol7.Setting.AppController;

import java.util.ArrayList;

import retrofit2.Callback;

import static android.R.attr.thumb;
import static android.R.attr.thumbnail;

/**
 * Created by asmarasusanto on 5/21/17.
 */

public class ImageAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    private ArrayList<String> mResources;
    private ImageLoader imageLoader = AppController.getInstance().getImageLoader();



    public ImageAdapter(Context context, ArrayList<String> mResources) {
        this.mResources = mResources;
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

        NetworkImageView thumbnail = (NetworkImageView) itemView.findViewById(R.id.pagerItem);
        thumbnail.setImageUrl(mResources.get(position), imageLoader);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
