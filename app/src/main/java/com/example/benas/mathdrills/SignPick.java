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
        final String mode = getIntent().getStringExtra("mode");
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
                intent.putExtra("mode",mode);
                startActivity(intent);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String minussign = minus.getText().toString();
                Intent intent = new Intent(SignPick.this,Levels.class);
                intent.putExtra("sign",minussign);
                intent.putExtra("mode",mode);
                startActivity(intent);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String multiplysign = multiply.getText().toString();
                Intent intent = new Intent(SignPick.this,Levels.class);
                intent.putExtra("sign",multiplysign);
                intent.putExtra("mode",mode);
                startActivity(intent);
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String divisionsign = division.getText().toString();
                Intent intent = new Intent(SignPick.this,Levels.class);
                intent.putExtra("sign",divisionsign);
                intent.putExtra("mode",mode);
                startActivity(intent);
            }
        });
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String randomsign = random.getText().toString();
                Intent intent = new Intent(SignPick.this,Levels.class);
                intent.putExtra("sign",randomsign);
                intent.putExtra("mode",mode);
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
