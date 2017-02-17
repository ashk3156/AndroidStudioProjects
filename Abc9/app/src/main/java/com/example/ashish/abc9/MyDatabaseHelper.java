package com.example.ashish.abc9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ashish on 12/18/2015.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABSE_NAME = "TheWorld";
    private static final int DATABSE_VERSION = 1;
    MyDatabaseHelper(Context context) {
        super(context, DATABSE_NAME, null ,DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CountriesDb.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        CountriesDb.onUpgrade(db, oldVersion, newVersion);
    }
}
