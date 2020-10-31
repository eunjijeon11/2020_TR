package com.example.mainscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag2 extends Fragment {

    View view;
    private Spinner spinner;
    ListView fx_lv;

    String[] element;
    String[] mid;
    String[] high;

    String[] fx_file_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2, container, false);

        spinner = view.findViewById(R.id.spinner);
        fx_lv = view.findViewById(R.id.lv_fx);

        element = getResources().getStringArray(R.array.fx_element);
        mid = getResources().getStringArray(R.array.fx_mid);
        high = getResources().getStringArray(R.array.fx_high);

        //final TextView fx_tv, grade_tv;

        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_2, android.R.id.text1, element) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View listview = super.getView(position, convertView, parent);
                TextView fx_tv, grade_tv;
                fx_tv = listview.findViewById(android.R.id.text1);
                grade_tv = listview.findViewById(android.R.id.text2);
                fx_tv.setTextSize(18);

                fx_tv.setText(element[position]);
                if (position < 6) grade_tv.setText("초등학교 4학년 1학기");
                else if (position < 12) grade_tv.setText("초등학교 4학년 2학기");
                else if (position < 18) grade_tv.setText("초등학교 5학년 1학기");
                else if (position < 24) grade_tv.setText("초등학교 5학년 2학기");
                else if (position < 30) grade_tv.setText("초등학교 6학년 1학기");
                else grade_tv.setText("초등학교 6학년 2학기");

                return listview;
            }
        };
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_2, android.R.id.text1, mid) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View listview = super.getView(position, convertView, parent);
                TextView fx_tv, grade_tv;
                fx_tv = listview.findViewById(android.R.id.text1);
                grade_tv = listview.findViewById(android.R.id.text2);
                fx_tv.setTextSize(18);

                fx_tv.setText(mid[position]);
                if (position < 5) {
                    grade_tv.setText("중학교 1학년 1학기");
                } else if (position < 11) {
                    grade_tv.setText("중학교 1학년 2학기");
                } else if (position < 18) {
                    grade_tv.setText("중학교 2학년 1학기");
                } else if (position < 24) {
                    grade_tv.setText("중학교 2학년 2학기");
                } else if (position < 32) {
                    grade_tv.setText("중학교 3학년 1학기");
                } else {
                    grade_tv.setText("중학교 3학년 2학기");
                }

                return listview;
            }
        };
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_2, android.R.id.text1, high) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View listview = super.getView(position, convertView, parent);
                TextView fx_tv, grade_tv;
                fx_tv = listview.findViewById(android.R.id.text1);
                grade_tv = listview.findViewById(android.R.id.text2);
                fx_tv.setTextSize(18);

                fx_tv.setText(high[position]);
                return listview;
            }
        };

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        fx_lv.setAdapter(adapter1);
                        break;
                    case 1:
                        fx_lv.setAdapter(adapter2);
                        break;
                    case 2:
                        fx_lv.setAdapter(adapter3);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                fx_lv.setAdapter(adapter1);
            }
        });

        final Intent intent = new Intent(getActivity(), FXActivity.class);
        fx_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (spinner.getSelectedItemPosition()) {
                    case 0:
                        fx_file_list = getResources().getStringArray(R.array.file_element);
                        intent.putExtra("fx_name", element[position]);
                        intent.putExtra("fx_grade", fx_file_list[position].substring(3,6));
                        break;
                    case 1:
                        fx_file_list = getResources().getStringArray(R.array.file_mid);
                        intent.putExtra("fx_name", mid[position]);
                        intent.putExtra("fx_grade", fx_file_list[position].substring(3,6));
                        break;
                    case 2:
                        fx_file_list = getResources().getStringArray(R.array.file_high);
                        intent.putExtra("fx_name", high[position]);
                        break;
                }
                intent.putExtra("fx_filename", fx_file_list[position]);
                startActivity(intent);
            }
        });

    return view;
    }
}