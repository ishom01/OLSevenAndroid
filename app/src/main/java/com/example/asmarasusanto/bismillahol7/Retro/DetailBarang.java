package com.example.asmarasusanto.bismillahol7.Retro;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asmarasusanto on 5/22/17.
 */
public class DetailBarang {

    @SerializedName("product") public Product data;

    public class Product   {

        @SerializedName("id") public String idBarnag;

        @SerializedName("name") public String nameBarang;

        @SerializedName("seller_username") public String sellerBarang;

        @SerializedName("seller_positive_feedback") public int feePoBarang;

        @SerializedName("seller_negative_feedback") public int feeNeBarang;

        @SerializedName("seller_delivery_time") public String delivBarang;

        @SerializedName("city") public String cityBarang;

        @SerializedName("stock") public String stockBarang;

        @SerializedName("seller_avatar") public String imgAvatar;

        @SerializedName("sold_count") public String soldBarang;

        @SerializedName("interest_count") public String interesBarang;

        @SerializedName("view_count") public String viewBarang;

        @SerializedName("price") public String priceBarang;

        @SerializedName("rating") public Rating rating;

        @SerializedName("desc") public String deskripsi;

        @SerializedName("images") public ArrayList<String> small_images ;

    }

    public class Rating {

        @SerializedName("average_rate") public String ratingAngka;

        @SerializedName("user_count") public String jumlahPerating;
    }
}
