package com.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class quiz extends AppCompatActivity {

    ImageView 문제;
    EditText 답란;
    Button 다음문제;
    String  단원;
    String 입력;
    String[] 답;
    String 파일명;

    int 문제넘버 = 1;
    int 점수=0;

    Intent quiz_end = new Intent(this, Quiz_End.class);
    InputStream is = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        문제 = findViewById(R.id.문제);
        답란 = findViewById(R.id.답란);
        다음문제 = findViewById(R.id.다음문제);

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
                파일명 = "e4";
                break;
        }

        try {
            is = getResources().getAssets().open("quiz/"+파일명+"_1.jpg");
            문제.setImageBitmap(BitmapFactory.decodeStream(is));
        } catch (IOException e) {
            e.printStackTrace();
        }

        다음문제.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                입력 = 답란.getText().toString();
                if(입력==답[문제넘버]) {
                    점수++;
                }
                if(문제넘버<20) {
                    문제넘버++;
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
