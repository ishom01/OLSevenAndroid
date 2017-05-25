package com.example.asmarasusanto.bismillahol7.Retro;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asmarasusanto on 5/19/17.
 */
public class ListTBarangFromKey {

    @SerializedName("products") public List<Product> data = null;

    public class Product   {

        @SerializedName("id") public String idBarnag;

        @SerializedName("name") public String nameBarang;

        @SerializedName("seller_username") public String sellerBarang;

        @SerializedName("seller_positive_feedback") public String feeBarang;

        @SerializedName("price") public String priceBarang;

        @SerializedName("small_images") public ArrayList<String> small_images ;

    }
}
