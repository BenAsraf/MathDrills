package com.example.benas.mathdrills;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


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
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, score TEXT, sign TEXT,level TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void add(String name, String score,String sign,String level) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("score", score);
        contentValues.put("sign",sign);
        contentValues.put("level",level);
        getWritableDatabase().insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getAll() {
        return (getReadableDatabase().rawQuery("SELECT name,score  FROM score_board", null));
    }

    public ArrayList<String> read(String sign, String level){
        Cursor cursor = getReadableDatabase().query(TABLE_NAME,null,null ,null,null,null,"score" + " DESC limit 5" );

        int NameIndex = cursor.getColumnIndex("name");
        int ScoreIndex = cursor.getColumnIndex("score");
        int signIndex = cursor.getColumnIndex("sign");
        int levelIndex = cursor.getColumnIndex("level");


        ArrayList<String> arrayList = new ArrayList<>();
        int i=1;
        while (cursor.moveToNext()) {
            if ( cursor.getString(signIndex).equals(sign) && cursor.getString(levelIndex).equals(level) ) {
                String person = i + ". " + cursor.getString(NameIndex) + " " + cursor.getString(ScoreIndex) ;
                i++;
                arrayList.add(person);
            }
        }
        return arrayList;
    }
}

