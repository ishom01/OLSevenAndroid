package com.example.asmarasusanto.bismillahol7.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asmarasusanto on 5/15/17.
 */

public class AksesTrend {

    private final SQLiteOpenHelper databaseHelper;

    public AksesTrend(SQLiteOpenHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    //Add barang ke dalam tabel barang
    public void addTrend(String trend, String seach) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        //menginisialisasi value string dengan kolom tabel
        ContentValues values = new ContentValues();
        values.put(SQLiteHandler.KEY_TREND, trend);
        values.put(SQLiteHandler.KEY_SEARCH, seach);

        // masukan ke tabel
        db.insert(SQLiteHandler.TABLE_TREND, null, values);
        db.close(); // Closing database connection
    }

    public Cursor getListTrend(){
        String selectQuery = "SELECT  * FROM " + SQLiteHandler.TABLE_TREND;
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor dataCursor = db.rawQuery(selectQuery, null);
        return dataCursor;
    }

    public void deleteListTrend() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.delete(SQLiteHandler.TABLE_TREND, null, null);
        db.close();
    }
}
