package com.example.asmarasusanto.bismillahol7.Chart;

import com.example.asmarasusanto.bismillahol7.Retro.ResponseChart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asmarasusanto on 5/24/17.
 */

public class Chart {
    private List<ResponseChart.Barang> items;
    private Seller seller;

    public List<ResponseChart.Barang> getItems() {
        return items;
    }

    public void setItems(List<ResponseChart.Barang> items) {
        this.items = items;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

}
