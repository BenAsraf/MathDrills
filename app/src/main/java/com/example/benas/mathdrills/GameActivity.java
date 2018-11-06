package com.example.benas.mathdrills;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
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
import java.util.Random;

public class GameActivity extends Activity {

    Button btnZero;
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnnine;
    Button enter;
    Button delete;
    Button nextdrill;
    Button exit;
    Button btnnegative;
    TextView firstnum;
    TextView secondnum;
    TextView signtv;
    EditText answer;
    int num1;
    int num2;
    boolean actionpressed;
    ImageView correct;
    ImageView wrong;
    String signcheck;
    TextView timer;
    TextView correctanswer;
    String level;
    int numcorrectanswer=0;
    ScoreBoard scoreboard = new ScoreBoard();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final String sign = getIntent().getStringExtra("sign");
        level = getIntent().getStringExtra("level");
        btnZero = findViewById(R.id.btn_0);
        btnOne = findViewById(R.id.btn_1);
        btnTwo = findViewById(R.id.btn_2);
        btnThree = findViewById(R.id.btn_3);
        btnFour = findViewById(R.id.btn_4);
        btnFive = findViewById(R.id.btn_5);
        btnSix = findViewById(R.id.btn_6);
        btnSeven = findViewById(R.id.btn_7);
        btnEight = findViewById(R.id.btn_8);
        btnnine = findViewById(R.id.btn_9);
        btnnegative = findViewById(R.id.btn_negative);
        enter = findViewById(R.id.enter);
        delete = findViewById(R.id.delete);
        nextdrill = findViewById(R.id.nextdrill);
        exit = findViewById(R.id.exit);
        firstnum = findViewById(R.id.firstnum);
        secondnum = findViewById(R.id.secondnum);
        signtv = findViewById(R.id.sign);
        answer = findViewById(R.id.answer);
        correct = findViewById(R.id.correct);
        wrong = findViewById(R.id.wrong);
        timer = findViewById(R.id.timer);
        correctanswer = findViewById(R.id.correctanswer);
        correctanswer.setText(Integer.toString(numcorrectanswer));
        String[] array = getResources().getStringArray(R.array.signsarray);
        String randomStr = array[new Random().nextInt(array.length)];
        signtv.setTextSize(70);
        switch (sign) {
            case "Plus":
                signtv.setText("+");
                break;
            case "Minus":
                signtv.setText("-");
                break;
            case "Multiply":
                signtv.setText("x");
                break;
            case "Division":
                signtv.setText("/");
                break;
            case "random signs":
                signtv.setText(randomStr);
                break;
            default:
                break;
        }
        randnumbers();

        numberbtnslistner numberbtnslistner = new numberbtnslistner();
        btnZero.setOnClickListener(numberbtnslistner);
        btnOne.setOnClickListener(numberbtnslistner);
        btnTwo.setOnClickListener(numberbtnslistner);
        btnThree.setOnClickListener(numberbtnslistner);
        btnFour.setOnClickListener(numberbtnslistner);
        btnFive.setOnClickListener(numberbtnslistner);
        btnSix.setOnClickListener(numberbtnslistner);
        btnSeven.setOnClickListener(numberbtnslistner);
        btnEight.setOnClickListener(numberbtnslistner);
        btnnine.setOnClickListener(numberbtnslistner);
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
                signcheck = signtv.getText().toString();
                checkdrill(signcheck);
                }
        });
        nextdrill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randnumbers();
                correct.setVisibility(View.GONE);
                wrong.setVisibility(View.GONE);
                nextdrill.setVisibility(View.GONE);
                answer.getText().clear();
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

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(""+millisUntilFinished / 1000);
                timer.setTextSize(25);

            }

            public void onFinish() {
                LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.dialog_endgame,null,false);
                final TextView correctanswers = view.findViewById(R.id.correctanswers);
                TextView usernameTV = view.findViewById(R.id.msg4);
                final EditText username = view.findViewById(R.id.username);
                correctanswers.setText(" "+numcorrectanswer+" ");
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this,R.style.DialogTheme);
                builder.setView(view);
                username.setVisibility(View.GONE);
                usernameTV.setVisibility(View.GONE);
                builder.setCancelable(false)
                        .setNeutralButton("Main menu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(GameActivity.this,MainActivity.class);
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
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("name",name);
                            contentValues.put("score",numcorrectanswer);
                            scoreboard.database.insert("score_board",null,contentValues);

                            Intent intent = new Intent(GameActivity.this,MainActivity.class);
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
            if (actionpressed) {
                answer.setText(numStr);
                actionpressed = false;
            } else
                answer.setText(answer.getText() + numStr);
        }
    }
    public void checkdrill (String sign){
        switch (sign) {
            case "+":
                if (num1 + num2 == Integer.parseInt(answer.getText().toString())) {
                    correct.setVisibility(View.VISIBLE);
                    wrong.setVisibility(View.GONE);
                    numcorrectanswer++;
                    correctanswer.setText(Integer.toString(numcorrectanswer));
                    nextdrill.setVisibility(View.VISIBLE);
                } else {
                    wrong.setVisibility(View.VISIBLE);
                    correct.setVisibility(View.GONE);
                }
                break;
            case "-":
                if (num1 - num2 == Integer.parseInt(answer.getText().toString())) {
                    correct.setVisibility(View.VISIBLE);
                    wrong.setVisibility(View.GONE);
                    numcorrectanswer++;
                    correctanswer.setText(Integer.toString(numcorrectanswer));
                    nextdrill.setVisibility(View.VISIBLE);
                } else {
                    wrong.setVisibility(View.VISIBLE);
                    correct.setVisibility(View.GONE);
                }
                break;
            case "x":
                if (num1 * num2 == Integer.parseInt(answer.getText().toString())) {
                    correct.setVisibility(View.VISIBLE);
                    wrong.setVisibility(View.GONE);
                    numcorrectanswer++;
                    correctanswer.setText(Integer.toString(numcorrectanswer));
                    nextdrill.setVisibility(View.VISIBLE);
                } else {
                    wrong.setVisibility(View.VISIBLE);
                    correct.setVisibility(View.GONE);
                }
                break;
            case "/":
                if (num1 + num2 == Integer.parseInt(answer.getText().toString())) {
                    correct.setVisibility(View.VISIBLE);
                    wrong.setVisibility(View.GONE);
                    numcorrectanswer++;
                    correctanswer.setText(Integer.toString(numcorrectanswer));
                    nextdrill.setVisibility(View.VISIBLE);
                }
            default:
                break;
        }

    }
    public void randnumbers (){
        Random rand = new Random();
        switch (level) {
            case "Level 1 0-10":
                num1 = rand.nextInt(10);
                num2 = rand.nextInt(10);
                break;
            case "Level 2 0-20":
                num1 = rand.nextInt(20);
                num2 = rand.nextInt(20);
                break;
            case "Level 3 0-50":
                num1 = rand.nextInt(50);
                num2 = rand.nextInt(50);
                break;
            case "Level 4 0-100":
                num1 = rand.nextInt(100);
                num2 = rand.nextInt(100);
                break;
            case "Level 5 0-500":
                num1 = rand.nextInt(500);
                num2 = rand.nextInt(500);
                break;
            case "Level 6 0-1000":
                num1 = rand.nextInt(1000);
                num2 = rand.nextInt(1000);
                break;
            default:
                break;
        }
        firstnum.setText(Integer.toString(num1));
        secondnum.setText(Integer.toString(num2));
        firstnum.setTextSize(70);
        secondnum.setTextSize(70);
    }

}