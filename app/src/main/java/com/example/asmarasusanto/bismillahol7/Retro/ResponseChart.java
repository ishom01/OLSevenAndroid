package com.example.asmarasusanto.bismillahol7.Retro;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asmarasusanto on 5/22/17.
 */
public class ResponseChart {

    @SerializedName("cart") public List<Cart> chart;

    public class Cart {
        @SerializedName("seller") public Seller seller;
        @SerializedName("items") public List<Barang> itemChart;

        public Seller getSeller() {
            return seller;
        }

        public void setSeller(Seller seller) {
            this.seller = seller;
        }

        public List<Barang> getItemChart() {
            return itemChart;
        }

        public void setItemChart(List<Barang> itemChart) {
            this.itemChart = itemChart;
        }
    }

    public class Barang {
        @SerializedName("id") public String idProduct;
        @SerializedName("name") public String nameProduct;
        @SerializedName("quantity") public String qtyProduct;
        @SerializedName("price") public String priceProduct;
        @SerializedName("stock") public String stockProduct;
        @SerializedName("courier") public List<String> courierProduct ;
        @SerializedName("small_images") public ArrayList<String> small_product ;

        public String getIdProduct() {
            return idProduct;
        }

        public void setIdProduct(String idProduct) {
            this.idProduct = idProduct;
        }

        public String getNameProduct() {
            return nameProduct;
        }

        public void setNameProduct(String nameProduct) {
            this.nameProduct = nameProduct;
        }

        public String getQtyProduct() {
            return qtyProduct;
        }

        public void setQtyProduct(String qtyProduct) {
            this.qtyProduct = qtyProduct;
        }

        public String getPriceProduct() {
            return priceProduct;
        }

        public void setPriceProduct(String priceProduct) {
            this.priceProduct = priceProduct;
        }

        public String getStockProduct() {
            return stockProduct;
        }

        public void setStockProduct(String stockProduct) {
            this.stockProduct = stockProduct;
        }

        public List<String> getCourierProduct() {
            return courierProduct;
        }

        public void setCourierProduct(List<String> courierProduct) {
            this.courierProduct = courierProduct;
        }
    }

    public class Seller {
        @SerializedName("id") public String idSeller;
        @SerializedName("username") public String usernameSeller;
        @SerializedName("name") public String nameSeller;

        public String getIdSeller() {
            return idSeller;
        }

        public void setIdSeller(String idSeller) {
            this.idSeller = idSeller;
        }

        public String getUsernameSeller() {
            return usernameSeller;
        }

        public void setUsernameSeller(String usernameSeller) {
            this.usernameSeller = usernameSeller;
        }

        public String getNameSeller() {
            return nameSeller;
        }

        public void setNameSeller(String nameSeller) {
            this.nameSeller = nameSeller;
        }
    }
}
