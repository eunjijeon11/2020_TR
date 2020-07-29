package com.example.mainscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag3 extends Fragment {

    private View view;
    private BarChart barChart;
    private int score;
    private int index = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        barChart = (BarChart) view.findViewById(R.id.bc); //barchart 연결

        score = -1;

        Bundle bundle = getArguments();

        if(bundle != null) {
            score = bundle.getInt("점수");
        }

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        if(score != -1 ) {
            barEntries.add(new BarEntry(index, score));
            index++;
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "bar");

        BarData data = new BarData(barDataSet);
        barChart.setData(data);

        return view;
    }
}
