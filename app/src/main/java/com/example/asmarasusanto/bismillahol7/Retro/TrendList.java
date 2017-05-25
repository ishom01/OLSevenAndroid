package com.example.asmarasusanto.bismillahol7.Retro;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asmarasusanto on 5/19/17.
 */
public class TrendList {

    @SerializedName("trends") public List<Trend> status;

    public class Trend {

        @SerializedName("name") public String namaTwet;

        @SerializedName("tweet_volume") public String twetVolume;

    }
}
