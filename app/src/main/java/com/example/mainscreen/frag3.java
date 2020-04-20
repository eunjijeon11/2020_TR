package com.example.mainscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag3 extends Fragment {

    private View view;
    private BarChart barChart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        barChart = (BarChart) view.findViewById(R.id.bc); //barchart 연결

        ArrayList<BarEntry> barEntries = new ArrayList<BarEntry>();
        //barchart에 들어갈 엔트리 리스트 생성

        final BarDataSet barDataSet = new BarDataSet(barEntries, "");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS); //barchart의 환경설정인 bardataset을 만들고 색 설정

        BarData data = new BarData(barDataSet); //데이터 객체 각각에 dataset 넣어주기
        data.setBarWidth(0.5f); //바 가로길이 0.5로 설정

        barChart.setData(data); //바 UI에 data 연결
        barChart.animateY(1000); //1초 간격 애니메이션
        barChart.invalidate(); //refresh

        if (getArguments() != null) {
            String quiz_name = getArguments().getString("name").toString();
            int right = getArguments().getInt("correct");
            int entire = getArguments().getInt("quiz");
            barEntries.add(new BarEntry(0,(float)right/entire));
        }

        return view;
    }
}
