package com.example.benas.mathdrills;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends Activity {

    public static final String MODE = "mode";
    public static final String SIGN = "sign";
    public static final String LEVEL = "level";
    public static final String PLAY = "play";
    public static final String SCOREBOARD = "scoreboard";
    public static final String PLUS_SIGN = "+";
    public static final String MINUS_SIGN = "-";
    public static final String MULTUPLY_SIGN = "*";
    public static final String DIVISION_SIGN = "/";
    public static final String RANDOM_SIGN = "rand";
    public static final String LEVEL_1 = "lvl 1";
    public static final String LEVEL_2 = "lvl 2";
    public static final String LEVEL_3 = "lvl 3";
    public static final String LEVEL_4 = "lvl 4";
    public static final String LEVEL_5 = "lvl 5";
    public static final String LEVEL_6 = "lvl 6";



    Button btnZero;
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button enter;
    Button delete;
    Button exit;
    Button btnnegative;
    TextView first_num;
    TextView second_num;
    TextView signtv;
    EditText answer;
    Integer num1;
    Integer num2;
    boolean action_pressed;
    ImageView wrong;
    String signcheck;
    TextView timer;
    TextView correct_answer;
    String level;
    String sign;
    String mode;
    int num_correct_answer =0;
    DatabaseHelper database;
    ArrayList<Integer> list;
    String randomStr;
    String[] array;
    Intent intent;
    boolean chk_answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        database = new DatabaseHelper(GameActivity.this);
        sign = getIntent().getStringExtra(SIGN);
        level = getIntent().getStringExtra(LEVEL);
        mode = getIntent().getStringExtra(MODE);
        btnZero = findViewById(R.id.btn_0);
        btnOne = findViewById(R.id.btn_1);
        btnTwo = findViewById(R.id.btn_2);
        btnThree = findViewById(R.id.btn_3);
        btnFour = findViewById(R.id.btn_4);
        btnFive = findViewById(R.id.btn_5);
        btnSix = findViewById(R.id.btn_6);
        btnSeven = findViewById(R.id.btn_7);
        btnEight = findViewById(R.id.btn_8);
        btnNine = findViewById(R.id.btn_9);
        btnnegative = findViewById(R.id.btn_negative);
        enter = findViewById(R.id.enter);
        delete = findViewById(R.id.delete);
        exit = findViewById(R.id.exit);
        first_num = findViewById(R.id.firstnum);
        second_num = findViewById(R.id.secondnum);
        signtv = findViewById(R.id.sign);
        answer = findViewById(R.id.answer);
        wrong = findViewById(R.id.wrong);
        timer = findViewById(R.id.timer);
        list = new ArrayList<Integer>();
        correct_answer = findViewById(R.id.correctanswer);
        correct_answer.setText(Integer.toString(num_correct_answer));
        array = getResources().getStringArray(R.array.signsarray);
        randomStr = array[new Random().nextInt(array.length)];
        chk_answer = false;
        signtv.setTextSize(70);

        if (sign == RANDOM_SIGN){
            signtv.setText(randomStr);
        }
        else
            signtv.setText(sign);

        randnumbers();

        final numberbtnslistner numberbtnslistner = new numberbtnslistner();
        btnZero.setOnClickListener(numberbtnslistner);
        btnOne.setOnClickListener(numberbtnslistner);
        btnTwo.setOnClickListener(numberbtnslistner);
        btnThree.setOnClickListener(numberbtnslistner);
        btnFour.setOnClickListener(numberbtnslistner);
        btnFive.setOnClickListener(numberbtnslistner);
        btnSix.setOnClickListener(numberbtnslistner);
        btnSeven.setOnClickListener(numberbtnslistner);
        btnEight.setOnClickListener(numberbtnslistner);
        btnNine.setOnClickListener(numberbtnslistner);
        btnZero.setOnClickListener(numberbtnslistner);
        btnnegative.setOnClickListener(numberbtnslistner);

        answer.setTextSize(50);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answer.length() > 0) {
                    String text = answer.getText().toString();
                    answer.setText(text.substring(0, text.length() - 1));
                }
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.length() > 0) {
                    signcheck = signtv.getText().toString();
                    checkdrill(signcheck);
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signcheck = signtv.getText().toString();
                Intent intent = new Intent(GameActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText(""+millisUntilFinished / 1000);
                timer.setTextSize(25);

            }

            public void onFinish() {
                intent = new Intent(GameActivity.this,MainActivity.class);
                LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.dialog_endgame,null,false);
                final TextView correctanswers = view.findViewById(R.id.correctanswers);
                TextView usernameTV = view.findViewById(R.id.msg4);
                final EditText username = view.findViewById(R.id.username);
                correctanswers.setText(" "+ num_correct_answer +" ");
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this,R.style.DialogTheme);
                builder.setView(view);
                username.setVisibility(View.GONE);
                usernameTV.setVisibility(View.GONE);
                builder.setCancelable(false)
                        .setNeutralButton("Main menu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(intent);
                            }
                        });
                    username.setVisibility(View.VISIBLE);
                    usernameTV.setVisibility(View.VISIBLE);
                    builder.setPositiveButton("Save score", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String name = "user1";
                            if(!username.getText().toString().equals(""))
                                name = username.getText().toString();
                            database.add(name,Integer.toString(num_correct_answer),sign,level);
                            startActivity(intent);
                        }
                    });
                builder.show();
            }

        }.start();
    }
    private class numberbtnslistner implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String numStr = ((Button) view).getText().toString();
            if (action_pressed) {
                answer.setText(numStr);
                action_pressed = false;
            } else
                answer.setText(answer.getText() + numStr);
        }
    }
    public void checkdrill (String sign){
        chk_answer = false;
        switch (sign) {
            case "+":
                if (num1 + num2 == Integer.parseInt(answer.getText().toString())) {
                    chk_answer = true;
                } else {
                    wrong.setVisibility(View.VISIBLE);
                }
                break;
            case "-":
                if (num1 - num2 == Integer.parseInt(answer.getText().toString())) {
                    chk_answer = true;
                } else {
                    wrong.setVisibility(View.VISIBLE);
                }
                break;
            case "x":
                if (num1 * num2 == Integer.parseInt(answer.getText().toString())) {
                    chk_answer = true;
                } else {
                    wrong.setVisibility(View.VISIBLE);
                }
                break;
            case "/":
                if (num1 / num2 == Integer.parseInt(answer.getText().toString())) {
                    chk_answer = true;
                }
            default:
                break;
        }
        if (chk_answer) {
            num_correct_answer++;
            correct_answer.setText(Integer.toString(num_correct_answer));
            randnumbers();
            wrong.setVisibility(View.GONE);
            answer.getText().clear();
            if (sign.equals(RANDOM_SIGN)) {
                randomStr = array[new Random().nextInt(array.length)];
                signtv.setText(randomStr);
            }
        }


    }
    public void randnumbers (){
        Random rand = new Random();
        int bound = 0;
        switch (level) {
            case LEVEL_1:
               bound = 10;
                break;
            case LEVEL_2:
                bound = 20;
                break;
            case LEVEL_3:
                bound = 50;
                break;
            case LEVEL_4:
                bound = 100;
                break;
            case LEVEL_5:
                bound = 500;
                break;
            case LEVEL_6:
                bound = 1000;
                break;
            default:
                break;
        }
        num2 = rand.nextInt(bound-1)+1;
        if (sign.equals(DIVISION_SIGN)){
                for (int i = num2; i <= bound; i++) {
                    if (i % num2 == 0)
                        list.add(i);
                }
                if (list.isEmpty()) {
                    num1 = num2;
                } else {
                    num1 = list.get(rand.nextInt(list.size()));
                    list.clear();
                }
        }
        else
            num1 = rand.nextInt(bound);

        first_num.setText(num1.toString());
        second_num.setText(num2.toString());
        first_num.setTextSize(70);
        second_num.setTextSize(70);
    }


}
