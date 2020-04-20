package com.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.widget.ListView;

public class Quiz_End extends AppCompatActivity {

    int correct;
    int wrong;
    ListView ox;
    int[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__end);

        ox = (ListView) findViewById(R.id.ox);

        Intent finsh = getIntent();
        correct = finsh.getExtras().getInt("정답");
        wrong = finsh.getExtras().getInt("오답");
        list = finsh.getExtras().getIntArray("리스트");
    }
}
