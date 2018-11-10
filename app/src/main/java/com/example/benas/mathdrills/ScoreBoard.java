package com.example.benas.mathdrills;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ScoreBoard extends Activity {

    DatabaseHelper database;
    TableLayout tableLayout;
    String level;
    String sign;
    String mode;
    Button back;
    Button main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        sign = getIntent().getStringExtra("sign");
        level = getIntent().getStringExtra("level");
        mode = getIntent().getStringExtra("mode");
        back = findViewById(R.id.back);
        main = findViewById(R.id.main);
        database = new DatabaseHelper(ScoreBoard.this);

        ArrayList<String> arrayList = database.read(sign, level);
        if (arrayList.isEmpty()) {
            Toast.makeText(ScoreBoard.this, "there is no scores to show", Toast.LENGTH_LONG).show();
        }
        else
            ReadScore(ScoreBoard.this,arrayList);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreBoard.this, Levels.class);
                intent.putExtra("sign", sign);
                intent.putExtra("mode",mode);
                startActivity(intent);
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreBoard.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void ReadScore(Context context, ArrayList arrayList) {
        tableLayout = findViewById(R.id.tableLayout);
        tableLayout.removeAllViews();

        GradientDrawable levelHeader = new GradientDrawable();
        levelHeader.setColor(Color.parseColor("#ec7f26"));
        levelHeader.setCornerRadii(new float[]{30, 30, 30, 30, 0, 0, 0, 0});
        levelHeader.setStroke(3, Color.parseColor("#000000"), 0, 0);

        GradientDrawable subTHeader = new GradientDrawable();
        subTHeader.setColor(Color.parseColor("#facfac"));
        subTHeader.setCornerRadii(new float[]{0, 0, 0, 0, 0, 0, 0, 0});
        subTHeader.setStroke(1, Color.parseColor("#000000"), 0, 0);

        ShapeDrawable border = new ShapeDrawable(new RectShape());
        border.getPaint().setStyle(Paint.Style.STROKE);
        border.getPaint().setColor(Color.BLACK);
        border.getPaint().setStrokeWidth(3);

        TableRow tableRow = new TableRow(context);
        TextView textView = new TextView(context);
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams();
        layoutParams.setMargins(0, 20, 0, 0);
        textView.setText("level " + level);
        tableRow.setBackground(levelHeader);
        tableRow.addView(textView);
        tableRow.setGravity(Gravity.CENTER);
        tableRow.setPadding(5, 10, 5, 10);
        tableRow.setLayoutParams(layoutParams);
        tableLayout.addView(tableRow);

        TableRow tableRowHeader = new TableRow(context);
        tableRowHeader.setBackground(subTHeader);
        TextView HeadertextView0 = new TextView(context);
        TextView HeadertextView1 = new TextView(context);
        TextView HeadertextView2 = new TextView(context);

        HeadertextView0.setText("position");
        HeadertextView0.setBackground(subTHeader);
        HeadertextView0.setPadding(3, 3, 3, 3);
        tableRowHeader.addView(HeadertextView0);

        HeadertextView1.setText("name");
        HeadertextView1.setBackground(subTHeader);
        HeadertextView1.setPadding(3, 3, 3, 3);
        tableRowHeader.addView(HeadertextView1);

        HeadertextView2.setText("drills");
        HeadertextView2.setBackground(subTHeader);
        HeadertextView2.setPadding(3, 3, 3, 3);
        tableRowHeader.addView(HeadertextView2);

        tableLayout.addView(tableRowHeader);
        int i=0;
        while (i<arrayList.size()) {
            TableRow tableScoresRow = new TableRow(context);
            TextView textViewID = new TextView(context);
            TextView textViewName = new TextView(context);
            TextView textViewScore = new TextView(context);
            String currScore = (String) arrayList.get(i);
            String[] info = currScore.split("-");
            textViewID.setGravity(Gravity.CENTER);
            textViewScore.setGravity(Gravity.CENTER);
            /*set text inside text views*/
            textViewID.setText("" + (i+1));
            textViewName.setText(info[0]);
            textViewScore.setText(info[1]);
            /* set padding*/
            textViewID.setPadding(5, 2, 2, 5);
            textViewName.setPadding(5, 2, 2, 5);
            textViewScore.setPadding(5, 2, 2, 5);
            /* set border */
            textViewID.setBackground(border);
            textViewName.setBackground(border);
            textViewScore.setBackground(border);
            /* enter to table row*/
            tableScoresRow.addView(textViewID);
            tableScoresRow.addView(textViewName);
            tableScoresRow.addView(textViewScore);
            tableLayout.addView(tableScoresRow);
            i++;
            }
    }
}

