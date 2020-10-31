package com.example.mainscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class frag3 extends Fragment {

    private View view;
    private BarChart barChart;
    ArrayList<BarEntry> barEntries;
    BarDataSet set;
    BarData barData;
    RecyclerView recyclerView;
    frag3_RecyclerViewAdapter recyclerViewAdapter;
    LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        barChart = view.findViewById(R.id.bc);
        recyclerView = view.findViewById(R.id.rv_analyze);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new frag3_RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        readDb();

        set = new BarDataSet(barEntries, "score");
        set.setValueTextColor(getResources().getColor(R.color.darkblue));
        set.setGradientColor(getResources().getColor(R.color.pink3), getResources().getColor(R.color.pink1));
        set.setHighLightColor(getResources().getColor(R.color.pink1));

        barData = new BarData(set);
        barChart.setData(barData);

        barChart.animateY(1000);
        barChart.setNoDataText("학습 내용이 없습니다");
        barChart.setNoDataTextColor(R.color.darkblue);
        barChart.setVisibleXRangeMaximum(6);
        barChart.setMaxVisibleValueCount(6);
        barChart.setVisibleYRangeMinimum(100, YAxis.AxisDependency.LEFT);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.moveViewToX(barData.getDataSetCount());
        barChart.getDescription().setEnabled(false);
        barChart.getAxisLeft().setAxisMinimum(0);
        barChart.getAxisRight().setAxisMinimum(0);
        barChart.setDrawBorders(true);
        barChart.setBorderWidth((float) 0.5);

        return view;
    }

    void readDb() {
        barEntries = new ArrayList<>();

        DBOpenHelper dbOpenHelper = new DBOpenHelper(getActivity());
        dbOpenHelper.open();

        Cursor cursor = dbOpenHelper.selectColumns();
        while (cursor.moveToNext()) {
            String tempFile = cursor.getString(cursor.getColumnIndex("filename"));
            int tempScore = cursor.getInt(cursor.getColumnIndex("score"));
            String tempDate = cursor.getString(cursor.getColumnIndex("date"));
            barEntries.add(new BarEntry(cursor.getPosition(), tempScore));
            Data data = new Data();
            data.setUnit(tempFile);
            data.setQuizScore(tempScore);
            data.setQuizDate(tempDate);
            recyclerViewAdapter.addItem(data);
        }
        recyclerViewAdapter.notifyDataSetChanged();
        dbOpenHelper.close();
    }
}
