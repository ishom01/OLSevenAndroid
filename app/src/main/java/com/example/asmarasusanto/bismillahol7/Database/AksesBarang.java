package com.example.asmarasusanto.bismillahol7.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asmarasusanto on 5/17/17.
 */

public class AksesBarang {

    private final SQLiteOpenHelper databaseHelper;

    public AksesBarang(SQLiteOpenHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    //Add barang ke dalam tabel barang
    public void addBarang(String id, String nama, String harga, String gambar) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        //menginisialisasi value string dengan kolom tabel
        ContentValues values = new ContentValues();
        values.put(SQLiteHandler.KEY_ID_BARANG, id);
        values.put(SQLiteHandler.KEY_NAMA_BARANG, nama);
        values.put(SQLiteHandler.KEY_HARGA_BARANG, harga);
        values.put(SQLiteHandler.KEY_GAMBAR_BARANG, gambar);

        // masukan ke tabel
        db.insert(SQLiteHandler.TABLE_BARANG, null, values);
        db.close(); // Closing database connection
    }

    public Cursor getListBarang(){
        String selectQuery = "SELECT  * FROM " + SQLiteHandler.TABLE_BARANG;
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor dataCursor = db.rawQuery(selectQuery, null);
        return dataCursor;
    }

    public void deleteListBarang() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.delete(SQLiteHandler.TABLE_TREND, null, null);
        db.close();
    }

}
