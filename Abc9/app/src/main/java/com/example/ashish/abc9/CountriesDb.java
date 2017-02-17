package com.example.ashish.abc9;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Ashish on 12/18/2015.
 */
public class CountriesDb {
    public static final String KEY_ROWID ="_id";
    public static final String KEY_CODE ="code";
    public static final String KEY_NAME ="name";
    public static final String KEY_CONTINENT ="continent";

    public static final String LOG_TAG ="CountriesDb";
    public static final String SQLITE_TABLE ="Country";
    public static final String DATABASE_CREATE ="CREATE TABLE if not exists " + SQLITE_TABLE + " ( "+ KEY_ROWID +
            " integer PRIMARY KEYautoincrement " + KEY_CODE + " , " + KEY_NAME + " , " + KEY_CONTINENT + " , " + " UNIQUE ( "+
            KEY_CODE + " ));";
    public static void onCreate(SQLiteDatabase db){
        Log.w(LOG_TAG, DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE);
    }
    public static void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        Log.w(LOG_TAG,"Upgrading database from version " + oldVersion+" to "+ newVersion+" ,which will destroy all old databases");
        db.execSQL("DROP TABLE IF EXISTS"+SQLITE_TABLE);
        onCreate(db);
    }
}
