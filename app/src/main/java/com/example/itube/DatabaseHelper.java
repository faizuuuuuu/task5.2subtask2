package com.example.itube;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME_FOR = "PlaylistDB";
    private static final int DB_VERSION_FOR = 1;

    private static final String TABLE_NAME = "playlist";
    private static final String COL_ID = "id";
    private static final String COL_URL = "url";

    public DatabaseHelper(Context context_for) {
        super(context_for, DB_NAME_FOR, null, DB_VERSION_FOR);
    }

    @Override
    public void onCreate(SQLiteDatabase db_for) {
        String query_for = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_URL + " TEXT)";
        db_for.execSQL(query_for);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db_for, int old_for, int new_for) {
        db_for.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db_for);
    }

    // Insert URL into playlist
    public void addToPlaylist(String url_for) {
        SQLiteDatabase db_for = this.getWritableDatabase();
        ContentValues values_for = new ContentValues();
        values_for.put(COL_URL, url_for);
        db_for.insert(TABLE_NAME, null, values_for);
        db_for.close();
    }

    // Retrieve all saved URLs
    public List<String> getPlaylist() {
        List<String> list_for_urls = new ArrayList<>();
        SQLiteDatabase db_for = this.getReadableDatabase();
        Cursor cur_for = db_for.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cur_for.moveToFirst()) {
            do {
                list_for_urls.add(cur_for.getString(1)); // index 1 = url
            } while (cur_for.moveToNext());
        }

        cur_for.close();
        db_for.close();
        return list_for_urls;
    }
}
