package com.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class quiz extends AppCompatActivity {

    ImageView 문제;
    EditText 답란;
    Button 다음문제;
    String 입력, 파일명, 단원;
    String[] 답;
    TextView quiznum;

    int 문제넘버 = 1;
    int 점수=0;

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_minus, btn_slash, btn_dot;
    ImageButton btn_bs;
    InputStream is = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        문제 = findViewById(R.id.문제);
        답란 = findViewById(R.id.답란);
        다음문제 = findViewById(R.id.다음문제);
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

        Intent start = getIntent();
        단원 = start.getStringExtra("단원");
        switch(단원) {
            case "사칙연산":
                답 = getResources().getStringArray(R.array.answer_e1);
                파일명 = "e1";
                break;
            case "분수":
                답 = getResources().getStringArray(R.array.answer_e2);
                파일명 = "e2";
                break;
            case "소수":
                답 = getResources().getStringArray(R.array.answer_e3);
                파일명 = "e3";
                break;
            case "정수":
                답 = getResources().getStringArray(R.array.answer_m1);
                파일명 = "m1";
                break;
            case "연방":
                답 = getResources().getStringArray(R.array.answer_m1);
                파일명 = "m2";
        }

        //문제 이미지 넘어가는 거
        try {
            is = getResources().getAssets().open("quiz/"+파일명+"_1.jpg");
            문제.setImageBitmap(BitmapFactory.decodeStream(is));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //키보드 구현
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"1";
                답란.setText(temp);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"2";
                답란.setText(temp);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"3";
                답란.setText(temp);
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"4";
                답란.setText(temp);
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"5";
                답란.setText(temp);
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"6";
                답란.setText(temp);
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"7";
                답란.setText(temp);
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"8";
                답란.setText(temp);
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"9";
                답란.setText(temp);
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"0";
                답란.setText(temp);
            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+".";
                답란.setText(temp);
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"-";
                답란.setText(temp);
            }
        });
        btn_slash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = 답란.getText()+"/";
                답란.setText(temp);
            }
        });
        btn_bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable temptext = 답란.getText();
                if(temptext.length()>0) {
                    temptext.delete(temptext.length()-1, temptext.length());
                    답란.setText(temptext);
                }
            }
        });

        final Intent quiz_end = new Intent(this, Quiz_End.class);
        //다음문제로 넘어가는 거
        다음문제.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                입력 = 답란.getText().toString();
                답란.setText("");
                if(입력==답[문제넘버]) {
                    점수++;
                }

                if(문제넘버<20) {
                    문제넘버++;
                    quiznum.setText("#"+문제넘버);
                    try {
                        is = getResources().getAssets().open("quiz/"+파일명+"_"+문제넘버+".jpg");
                        문제.setImageBitmap(BitmapFactory.decodeStream(is));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(문제넘버==20) {
                    quiz_end.putExtra("점수", 점수);
                    startActivity(quiz_end);
                }
            }
        });

    }
}
