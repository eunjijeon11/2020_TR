package com.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class FXActivity extends AppCompatActivity {

    String FX_NAME;
    String FX_FILENAME;
    String FX_GRADE;
    TextView fxname_tv;
    TextView grade_tv;
    ImageView fx_iv;

    String[] info;
    String level, grade, semester;
    String level_toText, grade_toText;

    InputStream is = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fx);

        fxname_tv = findViewById(R.id.tv_fxname);
        grade_tv = findViewById(R.id.tv_grade);
        fx_iv = findViewById(R.id.iv);

        Intent intent = getIntent();
        FX_NAME = intent.getStringExtra("fx_name");
        FX_FILENAME = intent.getStringExtra("fx_filename");
        FX_GRADE = intent.getStringExtra("fx_grade");

        info = FX_GRADE.split("");
        level = info[1];
        grade = info[2];
        semester = info[3];

        switch (level) {
            case "e":
                level_toText = "초등학교";
                break;
            case "m":
                level_toText = "중학교";
                break;
            case "h":
                level_toText = "고등학교";
                break;
        }

        fxname_tv.setText(FX_NAME);
        grade_toText = level_toText + " " + grade + "학년 " + semester + "학기";
        grade_tv.setText(grade_toText);

        try {
            is = getResources().getAssets().open("fx/" + FX_FILENAME + ".png");
            fx_iv.setImageBitmap(BitmapFactory.decodeStream(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
