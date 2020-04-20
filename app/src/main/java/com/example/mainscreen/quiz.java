package com.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class quiz extends AppCompatActivity {

    ImageView 문제;
    EditText 답란;
    Button 다음문제;
    String  단원;
    String 입력;
    String[] 답;

    int[] image;
    int 문제넘버 = 1;
    int 점수=0;

    Intent quiz_end = new Intent(this, Quiz_End.class);

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
                image = getResources().getIntArray(R.array.quiz_e1);
                답 = getResources().getStringArray(R.array.answer_e1);
                break;
            case "분수":
                image = getResources().getIntArray(R.array.quiz_e2);
                답 = getResources().getStringArray(R.array.answer_e2);
                break;
            case "소수":
                image = getResources().getIntArray(R.array.quiz_e3);
                답 = getResources().getStringArray(R.array.answer_e3);
                break;
            case "정수":
                image = getResources().getIntArray(R.array.quiz_m1);
                답 = getResources().getStringArray(R.array.answer_m1);
                break;
            case "연방":
                image = getResources().getIntArray(R.array.quiz_m2);
                break;
        }

        문제.setImageResource(image[0]);

        다음문제.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                입력 = 답란.getText().toString();
                if(입력==답[문제넘버-1]) {
                    점수 +=1;
                }
                if(문제넘버<20) {
                    문제.setImageResource(image[문제넘버]);
                    문제넘버 +=1;
                }
                else if(문제넘버==20) {
                    quiz_end.putExtra("점수", 점수);
                    startActivity(quiz_end);
                }
            }
        });

    }
}
