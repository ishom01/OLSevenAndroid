package com.example.asmarasusanto.bismillahol7.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by asmarasusanto on 5/15/17.
 */

public class SQLiteHandler extends SQLiteOpenHelper {

    private static final String TAG = SQLiteHandler.class.getSimpleName();

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "Bukalapak";

    // tabel chart
    public static final String TABLE_TREND = "Twit_Trend";

    // tabel barang
    public static final String TABLE_BARANG = "Barang";

    // tabel barang
    public static final String TABLE_USER = "User";


    // daftar kolom pada tabel barang
    public static final String KEY_ID_TREND = "idTrend";
    public static final String KEY_TREND = "keyTrend";
    public static final String KEY_SEARCH = "keySearch";
    public static final String KEY_LOCATION = "keyLocation";
    public static final String KEY_ID = "id";
    public static final String KEY_ID_BARANG = "idBarang";
    public static final String KEY_NAMA_BARANG = "namaBarang";
    public static final String KEY_HARGA_BARANG = "hargaBarang";
    public static final String KEY_GAMBAR_BARANG = "gambarBarang";
    public static final String KEY_USER_ID = "userId";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_USER_TOKEN = "userToken";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_OMNIKEY = "omniKey";


    // kode sqlite create tabel barang
    private  static  final String CREATE_TREND_TABLE = "CREATE TABLE " + TABLE_TREND + "("
            + KEY_ID_TREND+ " INTEGER PRIMARY KEY,"
            + KEY_TREND+ " TEXT,"
            + KEY_SEARCH+ " TEXT" + ")";

    private  static  final String CREATE_BARANG_LOGIN = "CREATE TABLE " + TABLE_USER + "("
            + KEY_ID+ " INTEGER PRIMARY KEY,"
            + KEY_USER_ID+ " TEXT,"
            + KEY_USERNAME+ " TEXT,"
            + KEY_USER_TOKEN+ " TEXT,"
            + KEY_EMAIL+ " TEXT,"
            + KEY_OMNIKEY+ " TEXT" + ")";

    private  static  final String CREATE_BARANG_TABLE = "CREATE TABLE " + TABLE_BARANG + "("
            + KEY_ID+ " INTEGER PRIMARY KEY,"
            + KEY_ID_BARANG+ " TEXT,"
            + KEY_NAMA_BARANG+ " TEXT,"
            + KEY_HARGA_BARANG+ " TEXT,"
            + KEY_GAMBAR_BARANG+ " TEXT" + ")";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TREND_TABLE);
        db.execSQL(CREATE_BARANG_TABLE);
        db.execSQL(CREATE_BARANG_LOGIN);
        Log.d(TAG, "Database tables created");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TREND);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BARANG);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        // Create tables again
        onCreate(db);
    }
}

