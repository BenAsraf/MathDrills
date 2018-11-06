package com.example.benas.mathdrills;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper database;

    private static final String DATABASE_NAME = "highscore";
    private static final String TABLE_NAME = "score_board";
    private static final int DATABASE_VERSION = 1;
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SCORE = "score";
    private Context context;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    public static synchronized DatabaseHelper getInstance(Context context) {

        if (database == null) {
            database = new DatabaseHelper(context.getApplicationContext());
        }
        return database;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    private void add (String name, String score){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("score",score);
    }
}
