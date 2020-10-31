package com.example.mainscreen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import static java.lang.Math.round;

public class frag1 extends Fragment {

    private String[] content;
    private int d;
    CardView e1, e2, e3, m1, m2, m3, m4, h1, h2, h3, h4;

    int progress = 0;
    int correct_rate = 0;
    ProgressBar progress_pb, correct_rate_pb;
    TextView progress_t, correct_rate_t;
    int[] is_complete = {0,0,0,0,0,0,0,0,0,0,0};
    ArrayList<String> fileArr = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.frag1, container, false);

        {e1 = view.findViewById(R.id.sachic);
        e2 = view.findViewById(R.id.bunsu);
        e3 = view.findViewById(R.id.sosu);
        m1 = view.findViewById(R.id.jungsu);
        m2 = view.findViewById(R.id.yeonb);
        m3 = view.findViewById(R.id.root);
        m4 = view.findViewById(R.id.insu);
        h1 = view.findViewById(R.id.dahang);
        h2 = view.findViewById(R.id.namugi);
        h3 = view.findViewById(R.id.log);
        h4 = view.findViewById(R.id.jisu);

        progress_pb = view.findViewById(R.id.progressbar1);
        correct_rate_pb = view.findViewById(R.id.progressbar2);
        progress_t = view.findViewById(R.id.progress_t);
        correct_rate_t = view.findViewById(R.id.correct_rate_t);} //findViewById

        content = getResources().getStringArray(R.array.small_unit);
        String[] tempArr = getResources().getStringArray(R.array.unit_name);
        fileArr.addAll(Arrays.asList(tempArr));

        init();

        updateProgress();

        return view;
    }

    void init() {
        final Intent intent = new Intent(getActivity(), content.class);
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=0;
                //Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명", "사칙연산");
                intent.putExtra("소단원명1", content[d]);
                intent.putExtra("소단원명2", content[d+1]);
                intent.putExtra("소단원명3", content[d+2]);
                startActivity(intent);
            }
        });
        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=3;
                //Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명", "분수계산");
                intent.putExtra("소단원명1", content[d]);
                intent.putExtra("소단원명2", content[d+1]);
                intent.putExtra("소단원명3", content[d+2]);
                startActivity(intent);
            }
        });
        e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=6;
                //Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명", "소수계산");
                intent.putExtra("소단원명1", content[d]);
                intent.putExtra("소단원명2", content[d+1]);
                intent.putExtra("소단원명3", content[d+2]);
                startActivity(intent);
            }
        });
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=9;
                //Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명", "정수계산");
                intent.putExtra("소단원명1", content[d]);
                intent.putExtra("소단원명2", content[d+1]);
                intent.putExtra("소단원명3", content[d+2]);
                startActivity(intent);
            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=12;
                //Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명", "연립방정식");
                intent.putExtra("소단원명1", content[d]);
                intent.putExtra("소단원명2", content[d+1]);
                intent.putExtra("소단원명3", content[d+2]);
                startActivity(intent);
            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=15;
                //Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명", "제곱근");
                intent.putExtra("소단원명1", content[d]);
                intent.putExtra("소단원명2", content[d+1]);
                intent.putExtra("소단원명3", content[d+2]);
                startActivity(intent);
            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=18;
                //Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명", "인수분해");
                intent.putExtra("소단원명1", content[d]);
                intent.putExtra("소단원명2", content[d+1]);
                intent.putExtra("소단원명3", content[d+2]);
                startActivity(intent);
            }
        });
        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=21;
                //Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명", "다항식 연산");
                intent.putExtra("소단원명1", content[d]);
                intent.putExtra("소단원명2", content[d+1]);
                intent.putExtra("소단원명3", content[d+2]);
                startActivity(intent);
            }
        });
        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=24;
                //Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명", "나머지정리");
                intent.putExtra("소단원명1", content[d]);
                intent.putExtra("소단원명2", content[d+1]);
                intent.putExtra("소단원명3", content[d+2]);
                startActivity(intent);
            }
        });
        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=27;
                //Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명", "로그");
                intent.putExtra("소단원명1", content[d]);
                intent.putExtra("소단원명2", content[d+1]);
                intent.putExtra("소단원명3", content[d+2]);
                startActivity(intent);
            }
        });
        h4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=30;
                //Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명", "지수");
                intent.putExtra("소단원명1", content[d]);
                intent.putExtra("소단원명2", content[d+1]);
                intent.putExtra("소단원명3", content[d+2]);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void updateProgress() {
        int completeNum = 0;
        int scoreSum = 0;

        DBOpenHelper dbOpenHelper = new DBOpenHelper(getActivity());
        dbOpenHelper.open();
        Cursor cursor = dbOpenHelper.selectColumns();
        while(cursor.moveToNext()) {
            String tempFile = cursor.getString(cursor.getColumnIndex("filename"));
            int tempScore = cursor.getInt(cursor.getColumnIndex("score"));
            is_complete[fileArr.indexOf(tempFile)]++;
            scoreSum += tempScore;
        }

        for (int value : is_complete) {
            if (value > 0) {
                completeNum++;
            }
        }

        float temp = completeNum/11f * 100;
        progress = round(temp);
        correct_rate = scoreSum/cursor.getCount();
        Log.e("progress", Integer.toString(progress));
        Log.e("correctRate", Integer.toString(correct_rate));

        progress_pb.setProgress(progress);
        correct_rate_pb.setProgress(correct_rate);

        progress_t.setText("학습진도: " + progress + "%");
        correct_rate_t.setText("정답률: " + correct_rate + "%");
        dbOpenHelper.close();
    }
}