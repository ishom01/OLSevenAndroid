package com.example.asmarasusanto.bismillahol7.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

/**
 * Created by asmarasusanto on 5/18/17.
 */

public class AksesLogin {
    private final SQLiteOpenHelper databaseHelper;

    public AksesLogin(SQLiteOpenHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    //Add barang ke dalam tabel barang
    public void addUserLogin(String userId, String userName, String userToken, String userEmail, String userOmnikey) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        //menginisialisasi value string dengan kolom tabel
        ContentValues values = new ContentValues();
        values.put(SQLiteHandler.KEY_USER_ID, userId);
        values.put(SQLiteHandler.KEY_USERNAME, userName);
        values.put(SQLiteHandler.KEY_USER_TOKEN, userToken);
        values.put(SQLiteHandler.KEY_EMAIL, userEmail);
        values.put(SQLiteHandler.KEY_OMNIKEY, userOmnikey);

        // masukan ke tabel
        db.insert(SQLiteHandler.TABLE_USER, null, values);
        db.close(); // Closing database connection
    }

    public HashMap<String, String> getUserData(){
        HashMap<String, String> user = new HashMap<String, String>();

        String selectQuery = "SELECT  * FROM " + SQLiteHandler.TABLE_USER;

        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor dataCursor = db.rawQuery(selectQuery, null);

        dataCursor.moveToFirst();
        if (dataCursor.getCount() > 0){
            user.put("user_id", dataCursor.getString(1));
            user.put("token", dataCursor.getString(3));
        }

        dataCursor.close();

        return user;
    }

    public void deleteUserLogin() {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.delete(SQLiteHandler.TABLE_USER, null, null);
        db.close();
    }

    public boolean cekLoginCache() {
        String selectQuery = "SELECT  * FROM " + SQLiteHandler.TABLE_TREND ;
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor dataCursor = db.rawQuery(selectQuery, null);
        if (dataCursor.getCount()<= 0) {
            dataCursor.close();
            return false;
        }
        dataCursor.close();
        return true;
    }
}
