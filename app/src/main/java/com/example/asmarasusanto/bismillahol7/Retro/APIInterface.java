package com.example.asmarasusanto.bismillahol7.Retro;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by asmarasusanto on 5/19/17.
 */

public interface APIInterface {
    @GET("products.json?")
    Call<ListTBarangFromKey> doGetListBarangFromKey(
            @Query("favorited") Boolean fav,
            @Query("keywords") String key
    );
//
    @POST("authenticate.json")
    Call<UserDetail> createUser(
            @Header("Authorization") String auth
    );

    @POST("carts/add_product/{productUrl}.json")
    Call<ResponseChart> postChart(
            @Path(value = "productUrl", encoded = true) String productUrl,
            @Header("Authorization") String auth,
            @Query("quantity") String qty
    );

    @GET("twitTiapLokasi.php?")
    Call<ArrayList<TrendList>> getTrendList(@Query("idCount") String key);

    @GET("products/{productUrl}.json")
    Call<DetailBarang> getDetailBarang(@Header("Content-Type") String cont, @Path(value = "productUrl", encoded = true) String productUrl);
//
//    @FormUrlEncoded
//    @POST("/api/users?")
//    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}
