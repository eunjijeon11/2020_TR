package com.example.mainscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
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
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class frag3 extends Fragment {

    private View view;
    private BarChart barChart;
    ArrayList<BarEntry> barEntries;
    BarDataSet set;
    BarData data;

    private BroadcastReceiver mLocalReceiver;
    private static final String LOCAL_BROADCAST_ACTION = "localBroadcastReceiver";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        setBarChart();

        return view;
    }

    void setBarChart() {
        barChart = (BarChart) view.findViewById(R.id.bc);
        setBarEntries();
        set = new BarDataSet(barEntries, "score");
        set.setValueTextColor(getResources().getColor(R.color.darkblue));
        set.setGradientColor(getResources().getColor(R.color.pink2), getResources().getColor(R.color.pink3));
        set.setHighLightColor(getResources().getColor(R.color.pink1));

        data = new BarData(set);
        barChart.setData(data);
    }

    void setBarEntries() {
        barEntries = new ArrayList<>();

        DBOpenHelper dbOpenHelper = new DBOpenHelper(getActivity());
        dbOpenHelper.open();

        Cursor cursor = dbOpenHelper.selectColumns();
        while (cursor.moveToNext()) {
            String tempFile = cursor.getString(cursor.getColumnIndex("filename"));
            int tempScore = cursor.getInt(cursor.getColumnIndex("score"));
            barEntries.add(new BarEntry(cursor.getPosition(), tempScore));
        }
        dbOpenHelper.close();
    }

    @Override
    public void onResume() {
        super.onResume();
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter(LOCAL_BROADCAST_ACTION);
        mLocalReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getBooleanExtra("sendvalue", false)) {
                    setBarEntries();
                }
            }
        };
        lbm.registerReceiver(mLocalReceiver, intentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(getContext());
        lbm.unregisterReceiver(mLocalReceiver);
    }
}
