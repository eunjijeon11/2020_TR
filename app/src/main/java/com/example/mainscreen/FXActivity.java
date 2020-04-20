package com.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FXActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fx);

        TextView tv_fxtitle = (TextView) findViewById(R.id.tv_fxtitle);
        ImageView imageView = (ImageView) findViewById(R.id.iv);

        Intent intent = getIntent();
        String title = intent.getExtras().getString("공식이름");
        int image = intent.getExtras().getInt("공식이미지");

        tv_fxtitle.setText("제목: "+title); //intent로 공식 이름 받아서 화면에 표시
        imageView.setImageResource(R.drawable.fx_e41); //intent로 공식 이미지 받아 화면에 표시

    } //frag2에서 공식 선택 시 나오는 화면이다.
}
