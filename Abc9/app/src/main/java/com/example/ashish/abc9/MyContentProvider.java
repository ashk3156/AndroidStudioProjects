package com.example.ashish.abc9;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    private MyDatabaseHelper dbHelper;
    private static final int ALL_COUNTRIES = 1;
    private static final int SINGLE_COUNTRY = 2;

    private static final String AUTHORITY = "com.as400samplecode.contentprovider";
    public static final Uri CONTENT_URI =Uri.parse("content://" + AUTHORITY + "/countries");

    private static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "countries", ALL_COUNTRIES);
        uriMatcher.addURI(AUTHORITY,"countries/#",SINGLE_COUNTRY);
    }


    /*public MyContentProvider() {
    }*/

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");0
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        //throw new UnsupportedOperationException("Not yet implemented");
        switch (uriMatcher.match(uri)) {
            case ALL_COUNTRIES:
                return "vnd.android.cursor.dir/vnd.com.com.as400samplecode.contentprovider";
            case SINGLE_COUNTRY:
                return "vnd.android.cursor.item/vnd.com.com.as400samplecode.contentprovider";
            default:
                throw new IllegalArgumentException("Unsupported URI:"+ uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        //throw new UnsupportedOperationException("Not yet implemented");
        SQLiteDatabase db =dbHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)){
            case ALL_COUNTRIES:
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI:"+ uri);
        }
        long id =db.insert(CountriesDb.SQLITE_TABLE,null,values);
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(CONTENT_URI + "/" + id);
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        dbHelper = new MyDatabaseHelper(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        //throw new UnsupportedOperationException("Not yet implemented");
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        SQLiteQueryBuilder queryBuilder= new SQLiteQueryBuilder();
        queryBuilder.setTables(CountriesDb.SQLITE_TABLE);

        switch (uriMatcher.match(uri)){
            case ALL_COUNTRIES:
                break;
            case SINGLE_COUNTRY:
                String id = uri.getPathSegments().get(1);
                queryBuilder.appendWhere(CountriesDb.KEY_ROWID + "=" + id);
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI:"+ uri);
        }
        Cursor cursor = queryBuilder.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
