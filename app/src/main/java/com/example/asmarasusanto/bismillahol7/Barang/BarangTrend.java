package com.example.asmarasusanto.bismillahol7.Barang;

/**
 * Created by asmarasusanto on 5/17/17.
 */

public class BarangTrend {
    private String id;
    private String urlFoto;
    private String keySearch;
    private String jumlah;

    public BarangTrend() {

    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getKeySearch() {
        return keySearch;
    }

    public void setKeySearch(String keySearch) {
        this.keySearch = keySearch;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }
}
