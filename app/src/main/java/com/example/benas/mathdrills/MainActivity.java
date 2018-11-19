package com.example.benas.mathdrills;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button play;
    Button exit;
    Button scoreboardBT;
    String mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play);
        exit = findViewById(R.id.exit);
        scoreboardBT = findViewById(R.id.scoreboard);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode =GameActivity.PLAY;
                Intent intent = new Intent(MainActivity.this, SignPick.class);
                intent.putExtra(GameActivity.MODE,mode);
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        scoreboardBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = GameActivity.SCOREBOARD;
                Intent intent = new Intent(MainActivity.this, SignPick.class);
                intent.putExtra(GameActivity.MODE,mode);
                startActivity(intent);

            }
        });
    }
}

