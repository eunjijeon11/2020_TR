package com.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class context extends AppCompatActivity {

    private TextView tv_context, 소단원1, 소단원2, 소단원3;
    private CardView button;
    private String 단원명, 소단원명1, 소단원명2, 소단원명3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);

        tv_context = (TextView) findViewById(R.id.context);
        소단원1 = (TextView) findViewById(R.id.소단원명1);
        소단원2 = (TextView) findViewById(R.id.소단원명2);
        소단원3 = (TextView) findViewById(R.id.소단원명3);
        //텍스트뷰 연결

        button = findViewById(R.id.시작);
        //버튼 연결

        Intent intent = getIntent();
        단원명=intent.getExtras().getString("단원명");
        소단원명1=intent.getStringExtra("소단원명1");
        소단원명2=intent.getStringExtra("소단원명2");
        소단원명3=intent.getStringExtra("소단원명3");
        //인텐트로 frag1에서 제목과 소단원명 받아옴

        tv_context.setText("-"+단원명);
        소단원1.setText("-"+소단원명1);
        소단원2.setText("-"+소단원명2);
        소단원3.setText("-"+소단원명3);
        //화면에 표시

        final Intent start_quiz= new Intent(this, quiz.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_quiz.putExtra("단원",단원명);
                startActivity(start_quiz);
            }
        });

    }
}
