package com.example.mainscreen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class quiz extends AppCompatActivity {

    ImageView quiz_iv;
    EditText answer_et;
    CardView next_quiz;
    String answer, filename, content;
    String[] answer_arr;
    TextView quiznum;

    int quiz_num = 1;
    int score = 0;

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_minus, btn_slash, btn_dot;
    ImageButton btn_bs;
    InputStream is = null;

    int[] ox = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    Intent start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quiz_iv = findViewById(R.id.문제);
        answer_et = findViewById(R.id.답란);
        next_quiz = findViewById(R.id.다음문제);
        quiznum = findViewById(R.id.tv_quiznum);

        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_0 = findViewById(R.id.btn_0);
        btn_dot = findViewById(R.id.btn_dot);
        btn_slash = findViewById(R.id.btn_slash);
        btn_minus = findViewById(R.id.btn_minus);
        btn_bs = findViewById(R.id.btn_bs);

        start = getIntent();
        //답 배열
        content = start.getStringExtra("단원");
        switch(content) {
            case "사칙연산":
                answer_arr = getResources().getStringArray(R.array.answer_e1);
                filename = "e1";
                break;
            case "분수":
                answer_arr = getResources().getStringArray(R.array.answer_e2);
                filename = "e2";
                break;
            case "소수":
                answer_arr = getResources().getStringArray(R.array.answer_e3);
                filename = "e3";
                break;
            case "정수":
                answer_arr = getResources().getStringArray(R.array.answer_m1);
                filename = "m1";
                break;
            case "연방":
                answer_arr = getResources().getStringArray(R.array.answer_m1);
                filename = "m2";
        }

        //문제 이미지 넘어가는 거
        try {
            is = getResources().getAssets().open("quiz/"+ filename +"_1.jpg");
            quiz_iv.setImageBitmap(BitmapFactory.decodeStream(is));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //키보드 구현
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"1";
                answer_et.setText(temp);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"2";
                answer_et.setText(temp);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"3";
                answer_et.setText(temp);
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"4";
                answer_et.setText(temp);
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"5";
                answer_et.setText(temp);
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"6";
                answer_et.setText(temp);
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"7";
                answer_et.setText(temp);
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"8";
                answer_et.setText(temp);
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"9";
                answer_et.setText(temp);
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"0";
                answer_et.setText(temp);
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+".";
                answer_et.setText(temp);
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"-";
                answer_et.setText(temp);
            }
        });
        btn_slash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = answer_et.getText()+"/";
                answer_et.setText(temp);
            }
        });
        btn_bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable temptext = answer_et.getText();
                if(temptext.length()>0) {
                    temptext.delete(temptext.length()-1, temptext.length());
                    answer_et.setText(temptext);
                }
            }
        });


        final Intent quiz_end = new Intent(this, Quiz_End.class);
        //다음문제로 넘어가는 거
        next_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = answer_et.getText().toString();
                answer_et.setText("");
                if(answer.equals(answer_arr[quiz_num - 1])) {
                    score++;
                    ox[quiz_num -1]++;
                }

                if(quiz_num <20) {
                    quiz_num++;
                    quiznum.setText("#"+ quiz_num);
                    try {
                        is = getResources().getAssets().open("quiz/"+ filename +"_"+ quiz_num +".jpg");
                        quiz_iv.setImageBitmap(BitmapFactory.decodeStream(is));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(quiz_num ==20) {
                    quiz_end.putExtra("점수", score);
                    quiz_end.putExtra("ox", ox);
                    quiz_end.putExtra("파일명", filename);
                    startActivity(quiz_end);
                    finish();
                }
            }
        });
    }
}
