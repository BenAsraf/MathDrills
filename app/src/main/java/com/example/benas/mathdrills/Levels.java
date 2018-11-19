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
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        sign = getIntent().getStringExtra(GameActivity.SIGN);
        mode = getIntent().getStringExtra(GameActivity.MODE);
        lvl1 = findViewById(R.id.lvl1);
        lvl2 = findViewById(R.id.lvl2);
        lvl3 = findViewById(R.id.lvl3);
        lvl4 = findViewById(R.id.lvl4);
        lvl5 = findViewById(R.id.lvl5);
        lvl6 = findViewById(R.id.lvl6);
        back = findViewById(R.id.back);

        if (mode.equals("play")) {
            intent = new Intent(Levels.this, GameActivity.class);
            intent.putExtra(GameActivity.SIGN, sign);
            intent.putExtra(GameActivity.MODE,mode);
        }
        else{
            intent = new Intent(Levels.this, ScoreBoard.class);
            intent.putExtra(GameActivity.SIGN, sign);
            intent.putExtra(GameActivity.MODE,mode);
        }

        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(GameActivity.LEVEL, GameActivity.LEVEL_1);
                startActivity(intent);
            }
        });
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(GameActivity.LEVEL, GameActivity.LEVEL_2);
                startActivity(intent);
            }
        });
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(GameActivity.LEVEL, GameActivity.LEVEL_3);
                startActivity(intent);
            }
        });
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(GameActivity.LEVEL, GameActivity.LEVEL_4);
                startActivity(intent);
            }
        });
        lvl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(GameActivity.LEVEL, GameActivity.LEVEL_5);
                startActivity(intent);
            }
        });
        lvl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(GameActivity.LEVEL, GameActivity.LEVEL_6);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_back = new Intent(Levels.this,SignPick.class);
                intent_back.putExtra(GameActivity.SIGN,sign);
                intent_back.putExtra(GameActivity.MODE,mode);
                startActivity(intent_back);
            }
        });

    }
}
