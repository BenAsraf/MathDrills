package com.example.benas.mathdrills;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreBoard extends Activity {

    DatabaseHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        final String sign = getIntent().getStringExtra("sign");
        final String level = getIntent().getStringExtra("level");

        ListView listView = findViewById(R.id.listview);
        database = new DatabaseHelper(ScoreBoard.this);

        ArrayList<String> arrayList = database.read(sign,level);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
