package com.example.benas.mathdrills;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ScoreBoard extends Activity {

    final String TABLE_NAME = "score_board";

    final String CREATE_TABLE_CMD="CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, score TEXT);";

    private static SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

    database = openOrCreateDatabase("database.sql",MODE_PRIVATE,null);
        database.execSQL(CREATE_TABLE_CMD);
        ListView listView = findViewById(R.id.persons_list);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        adapter.clear();

        Cursor cursor = database.query(TABLE_NAME,null,null,null,null,null,"score"+" DESC");

        int IdIndex = cursor.getColumnIndex("id");
        int NameIndex = cursor.getColumnIndex("name");
        int ScoreIndex = cursor.getColumnIndex("score");

        while (cursor.moveToNext()) {
            String person = cursor.getString(IdIndex) + ". " +cursor.getString(NameIndex) + " " + cursor.getString(ScoreIndex);
            adapter.add(person);
        }

        adapter.notifyDataSetChanged();
    }

}
