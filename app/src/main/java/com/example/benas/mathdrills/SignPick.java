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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_pick);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.division);
        random = findViewById(R.id.random);
        back = findViewById(R.id.back);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plussign = plus.getText().toString();
                Intent intent = new Intent(SignPick.this,Levels.class);
                intent.putExtra("sign",plussign);
                startActivity(intent);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String minussign = minus.getText().toString();
                Intent intent = new Intent(SignPick.this,Levels.class);
                intent.putExtra("sign",minussign);
                startActivity(intent);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String multiplysign = multiply.getText().toString();
                Intent intent = new Intent(SignPick.this,Levels.class);
                intent.putExtra("sign",multiplysign);
                startActivity(intent);
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String divisionsign = division.getText().toString();
                Intent intent = new Intent(SignPick.this,Levels.class);
                intent.putExtra("sign",divisionsign);
                startActivity(intent);
            }
        });
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String randomsign = random.getText().toString();
                Intent intent = new Intent(SignPick.this,Levels.class);
                intent.putExtra("sign",randomsign);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignPick.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
