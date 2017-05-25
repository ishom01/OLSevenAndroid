package com.example.asmarasusanto.bismillahol7.Barang;

/**
 * Created by asmarasusanto on 5/17/17.
 */

public class Barang {
    private String id;
    private String urlFoto;
    private String namaBarang;
    private String hargaBarang;
    private String tokoBarang;
    private String feeBarang;
    private String keySearch;

    public String getKeySearch() {
        return keySearch;
    }

    public void setKeySearch(String keySearch) {
        this.keySearch = keySearch;
    }

    private String[] kate;

    public Barang() {

    }

    public String getTokoBarang() {
        return tokoBarang;
    }

    public void setTokoBarang(String tokoBarang) {
        this.tokoBarang = tokoBarang;
    }

    public String getFeeBarang() {
        return feeBarang;
    }

    public void setFeeBarang(String feeBarang) {
        this.feeBarang = feeBarang;
    }

    public Barang(String id, String namaBarang, String hargaBarang, String thumbnailUrl ) {
        this.id = id;
        this.namaBarang= namaBarang;
        this.hargaBarang = hargaBarang;
        this.urlFoto = thumbnailUrl;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;

    }

    public String[] getArray() {
        return kate;
    }

    public void setArray(int possition, String value) {
        kate[possition] = value;
    }

    public int arrayLength(){
        return kate.length;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(String hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
}
