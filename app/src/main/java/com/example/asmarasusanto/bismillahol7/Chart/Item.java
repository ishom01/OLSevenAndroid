package com.example.asmarasusanto.bismillahol7.Chart;

import java.util.ArrayList;

/**
 * Created by asmarasusanto on 5/24/17.
 */
public class Item {
    private String idItem;
    private String nameItem;
    private String qtyItem;
    private String priceItem;
    private String stockItem;
    private String imgItem;
    private ArrayList<String> kurirItem;

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getQtyItem() {
        return qtyItem;
    }

    public void setQtyItem(String qtyItem) {
        this.qtyItem = qtyItem;
    }

    public String getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(String priceItem) {
        this.priceItem = priceItem;
    }

    public String getStockItem() {
        return stockItem;
    }

    public void setStockItem(String stockItem) {
        this.stockItem = stockItem;
    }

    public String getImgItem() {
        return imgItem;
    }

    public void setImgItem(String imgItem) {
        this.imgItem = imgItem;
    }

    public ArrayList<String> getKurirItem() {
        return kurirItem;
    }

    public void setKurirItem(String kurir) {
        kurirItem.add(kurir);
    }
}
