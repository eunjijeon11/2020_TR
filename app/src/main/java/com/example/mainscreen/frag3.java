package com.example.mainscreen;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag3 extends Fragment {

    private View view;
    private BarChart barChart;
    private float score;
    DBHelper mydb;
    ArrayList<BarEntry> barEntries;
    BarDataSet set;
    BarData data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        barChart = (BarChart) view.findViewById(R.id.bc); //barchart 연결

        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0, 20));

        set = new BarDataSet(barEntries, "score");
        set.setValueTextColor(getResources().getColor(R.color.darkblue));
        set.setGradientColor(getResources().getColor(R.color.pink2), getResources().getColor(R.color.pink3));
        set.setHighLightColor(getResources().getColor(R.color.pink1));

        data = new BarData(set);
        barChart.setData(data);

        mydb = new DBHelper(getContext());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Cursor cursor = mydb.getAllData();
        if (cursor.getCount() >= barEntries.size()) {
            cursor.moveToNext();
        }
        score = cursor.getInt(cursor.getColumnIndex("score"));
        barEntries.add(new BarEntry(barEntries.size(), score));
        set.notifyDataSetChanged();
        barChart.notifyDataSetChanged();
        barChart.invalidate();
        cursor.close();
    }
}
