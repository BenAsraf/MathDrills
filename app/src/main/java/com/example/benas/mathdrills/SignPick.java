package com.example.benas.mathdrills;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignPick extends Activity {

    Button plus;
    Button minus;
    Button multiply;
    Button division;
    Button random;
    Button back;
    Intent intent;
    String mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_pick);
        mode = getIntent().getStringExtra(GameActivity.MODE);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.division);
        random = findViewById(R.id.random);
        back = findViewById(R.id.back);
        intent = new Intent(SignPick.this,Levels.class);
        intent.putExtra(GameActivity.MODE, mode);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(GameActivity.SIGN,GameActivity.PLUS_SIGN);
                startActivity(intent);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(GameActivity.SIGN,GameActivity.MINUS_SIGN);
                startActivity(intent);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(GameActivity.SIGN,GameActivity.MULTUPLY_SIGN);
                startActivity(intent);
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(GameActivity.SIGN,GameActivity.DIVISION_SIGN);
                startActivity(intent);
            }
        });

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(GameActivity.SIGN,GameActivity.RANDOM_SIGN);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_exit = new Intent(SignPick.this,MainActivity.class);
                startActivity(intent_exit);
            }
        });

    }
}
