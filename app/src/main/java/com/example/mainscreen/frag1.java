package com.example.mainscreen;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Trace;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class frag1 extends Fragment {

    private View view;
    private CardView 사칙연산, 분수, 소수, 정수, 연방, 제곱근, 인수, 다항식, 나머지, 로그, 지수;
    private String[] 소단원명;
    private int d;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

        사칙연산 = (CardView) view.findViewById(R.id.sachic);
        분수 = (CardView) view.findViewById(R.id.bunsu);
        소수 = (CardView) view.findViewById(R.id.sosu);
        정수 = (CardView) view.findViewById(R.id.jungsu);
        연방 = (CardView) view.findViewById(R.id.yeonb);
        제곱근 = (CardView) view.findViewById(R.id.root);
        인수 = (CardView) view.findViewById(R.id.insu);
        다항식 = (CardView) view.findViewById(R.id.dahang);
        나머지 = (CardView) view.findViewById(R.id.namugi);
        로그 = (CardView) view.findViewById(R.id.log);
        지수 = (CardView) view.findViewById(R.id.jisu);

        //test

        소단원명 = getResources().getStringArray(R.array.소단원);

        사칙연산.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=0;
                Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명","사칙연산");
                intent.putExtra("소단원명1",소단원명[d]);
                intent.putExtra("소단원명2",소단원명[d+1]);
                intent.putExtra("소단원명3",소단원명[d+2]);
                startActivity(intent);
            }
        });
        분수.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=3;
                Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명","분수");
                intent.putExtra("소단원명1",소단원명[d]);
                intent.putExtra("소단원명2",소단원명[d+1]);
                intent.putExtra("소단원명3",소단원명[d+2]);
                startActivity(intent);
            }
        });
        소수.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=6;
                Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명","소수");
                intent.putExtra("소단원명1",소단원명[d]);
                intent.putExtra("소단원명2",소단원명[d+1]);
                intent.putExtra("소단원명3",소단원명[d+2]);
                startActivity(intent);
            }
        });

        return view;
    }

}