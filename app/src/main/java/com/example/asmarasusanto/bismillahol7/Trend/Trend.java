package com.example.asmarasusanto.bismillahol7.Trend;

/**
 * Created by asmarasusanto on 5/16/17.
 */

public class Trend {

    String keyTrend, keySearch;

    public Trend(String keyTrend, String keySearch) {
        this.keySearch = keySearch;
        this.keyTrend = keyTrend;
    }

    public String getKeyTrend() {
        return keyTrend;
    }

    public void setKeyTrend(String keyTrend) {
        this.keyTrend = keyTrend;
    }

    public String getKeySearch() {
        return keySearch;
    }

    public void setKeySearch(String keySearch) {
        this.keySearch = keySearch;
    }
}

