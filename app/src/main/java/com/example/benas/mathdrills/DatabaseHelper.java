package com.example.benas.mathdrills;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static java.sql.Types.REAL;


public class DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "highscore";
    private static final String TABLE_NAME = "score_board";
    private static final int DATABASE_VERSION = 1;
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SCORE = "score";
    private static final String SIGN = "sign";
    private static final String LEVEL = "level";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, score TEXT , sign TEXT,level TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void add(String name, String score,String sign,String level) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(SCORE, score);
        contentValues.put(SIGN,sign);
        contentValues.put(LEVEL,level);
        getWritableDatabase().insert(TABLE_NAME, null, contentValues);
    }


    public ArrayList<String> read(String sign, String level){
        Cursor cursor = getReadableDatabase().rawQuery("SELECT  * FROM " + TABLE_NAME +" ORDER BY CAST(score AS REAL) DESC " ,null);

        int NameIndex = cursor.getColumnIndex(NAME);
        int ScoreIndex = cursor.getColumnIndex(SCORE);
        int signIndex = cursor.getColumnIndex(SIGN);
        int levelIndex = cursor.getColumnIndex(LEVEL);


        ArrayList<String> arrayList = new ArrayList<>();
        while (cursor.moveToNext()) {
            if ( cursor.getString(signIndex).equals(sign) && cursor.getString(levelIndex).equals(level) ) {
                String person = cursor.getString(NameIndex) + "-" + cursor.getString(ScoreIndex) ;
                arrayList.add(person);
            }
        }
        return arrayList;
    }
}

