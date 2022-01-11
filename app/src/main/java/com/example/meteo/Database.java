package com.example.meteo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_TABLE_NAME = "MeteoDB";
    private static final String PKEY = "pkey";
    private static final String COL1 = "City";

    Database (Context context) { super(context, DATABASE_TABLE_NAME, null, DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String DATABASE_TABLE_CREATE = "CREATE TABLE " + DATABASE_TABLE_NAME + " (" +
                PKEY + " INTEGER PRIMARY KEY, " +
                COL1 + " TEXT);";
        db.execSQL(DATABASE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertCity(String s) {
        SQLiteDatabase db =getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(COL1, s);
        db.insertOrThrow(DATABASE_TABLE_NAME, null, values);
        System.out.println("---------------------------------------------------------------------------------- let's go");
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public void readData()
    {
        Log.i("APP", "Reading database...");
        String select = new String("SELECT DISTINCT * from " + DATABASE_TABLE_NAME);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        Log.i("APP", "Number of entries: " + cursor.getCount());
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Log.i("APP", "Reading: " + cursor.getString(cursor.getColumnIndex(COL1)));
            } while (cursor.moveToNext());
        }
    }


}
