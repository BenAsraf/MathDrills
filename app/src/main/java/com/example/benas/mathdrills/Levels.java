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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        final String sign = getIntent().getStringExtra("sign");
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
                Intent intent = new Intent(Levels.this,GameActivity.class);
                String level1 = lvl1.getText().toString();
                intent.putExtra("sign", sign);
                intent.putExtra("level",level1);
                startActivity(intent);
            }
        });
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Levels.this,GameActivity.class);
                String level2 = lvl2.getText().toString();
                intent.putExtra("sign", sign);
                intent.putExtra("level",level2);
                startActivity(intent);
            }
        });
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Levels.this,GameActivity.class);
                String level3 = lvl3.getText().toString();
                intent.putExtra("sign", sign);
                intent.putExtra("level",level3);
                startActivity(intent);
            }
        });
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Levels.this,GameActivity.class);
                String level4 = lvl4.getText().toString();
                intent.putExtra("sign", sign);
                intent.putExtra("level",level4);
                startActivity(intent);
            }
        });
        lvl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Levels.this,GameActivity.class);
                String level5 = lvl5.getText().toString();
                intent.putExtra("sign", sign);
                intent.putExtra("level",level5);
                startActivity(intent);
            }
        });
        lvl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Levels.this,GameActivity.class);
                String level6 = lvl6.getText().toString();
                intent.putExtra("sign", sign);
                intent.putExtra("level",level6);
                startActivity(intent);
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
