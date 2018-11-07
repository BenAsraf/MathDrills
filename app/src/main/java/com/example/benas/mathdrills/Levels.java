package com.example.benas.mathdrills;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Levels extends Activity {


    Button lvl1;
    Button lvl2;
    Button lvl3;
    Button lvl4;
    Button lvl5;
    Button lvl6;
    Button back;
    String sign;
    String mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        sign = getIntent().getStringExtra("sign");
        mode = getIntent().getStringExtra("mode");
        lvl1 = findViewById(R.id.lvl1);
        lvl2 = findViewById(R.id.lvl2);
        lvl3 = findViewById(R.id.lvl3);
        lvl4 = findViewById(R.id.lvl4);
        lvl5 = findViewById(R.id.lvl5);
        lvl6 = findViewById(R.id.lvl6);
        back = findViewById(R.id.back);

        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String level1 = lvl1.getText().toString();
                if (mode.equals("play")) {
                    Intent intent = new Intent(Levels.this, GameActivity.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "1");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Levels.this, ScoreBoard.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "1");
                    startActivity(intent);
                }
            }
        });
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String level2 = lvl2.getText().toString();
                if (mode.equals("play")) {
                    Intent intent = new Intent(Levels.this, GameActivity.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "2");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Levels.this, ScoreBoard.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "2");
                    startActivity(intent);
                }
            }
        });
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String level3 = lvl3.getText().toString();
                if (mode.equals("play")) {
                    Intent intent = new Intent(Levels.this, GameActivity.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "3");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Levels.this, ScoreBoard.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "3");
                    startActivity(intent);
                }
            }
        });
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String level4 = lvl4.getText().toString();
                if (mode.equals("play")) {
                    Intent intent = new Intent(Levels.this, GameActivity.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "4");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Levels.this, ScoreBoard.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "4");
                    startActivity(intent);
                }
            }
        });
        lvl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String level5 = lvl5.getText().toString();
                if (mode.equals("play")) {
                    Intent intent = new Intent(Levels.this, GameActivity.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "5");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Levels.this, ScoreBoard.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "5");
                    startActivity(intent);
                }
            }
        });
        lvl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String level6 = lvl6.getText().toString();
                if (mode.equals("play")) {
                    Intent intent = new Intent(Levels.this, GameActivity.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "6");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Levels.this, ScoreBoard.class);
                    intent.putExtra("sign", sign);
                    intent.putExtra("level", "6");
                    startActivity(intent);
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Levels.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
