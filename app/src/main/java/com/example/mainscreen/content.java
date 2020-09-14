package com.example.mainscreen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class content extends AppCompatActivity {

    private TextView tv_content, tv_small1, tv_small2, tv_small3;
    private CardView button;
    private String content, small_1, small_2, small_3;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        tv_content = (TextView) findViewById(R.id.content);
        tv_small1 = (TextView) findViewById(R.id.소단원명1);
        tv_small2 = (TextView) findViewById(R.id.소단원명2);
        tv_small3 = (TextView) findViewById(R.id.소단원명3);
        //텍스트뷰 연결

        button = findViewById(R.id.시작);
        //버튼 연결

        intent = getIntent();
        content=intent.getExtras().getString("단원명");
        small_1=intent.getStringExtra("소단원명1");
        small_2=intent.getStringExtra("소단원명2");
        small_3=intent.getStringExtra("소단원명3");
        //인텐트로 frag1에서 제목과 소단원명 받아옴

        tv_content.setText("-" + content);
        tv_small1.setText("-" + small_1);
        tv_small2.setText("-" + small_2);
        tv_small3.setText("-" + small_3);
        //화면에 표시

        final Intent start_quiz= new Intent(this, quiz.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_quiz.putExtra("단원",content);
                startActivity(start_quiz);
                finish();
            }
        });
    }
}
