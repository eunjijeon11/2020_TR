package com.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class Quiz_End extends AppCompatActivity {

    int 점수;
    ListView ox;
    int[] list;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__end);

        ox = (ListView) findViewById(R.id.ox);
        score = (TextView)findViewById(R.id.score);

        Intent intent = getIntent();
        점수 = intent.getExtras().getInt("점수");
        score.setText(점수);

    }
}
