package com.example.mainscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag2 extends Fragment {

    View view;
    private Spinner spinner;
    String[] list1;
    int 학교;
    int[] Image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2, container, false);

        list1 = getResources().getStringArray(R.array.fx_element);

        final ArrayAdapter adapter1 = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list1);
        final fxListviewAdapter adapter2 = new fxListviewAdapter();
        final fxListviewAdapter adapter3 = new fxListviewAdapter();

        final ListView list = (ListView) view.findViewById(R.id.lst);

        spinner = (Spinner) view.findViewById(R.id.spr);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        list.setAdapter(adapter1);
                        학교 = 0;
                        break;
                    case 1:
                        list.setAdapter(adapter2);
                        학교 = 1;
                        break;
                    case 2:
                        list.setAdapter(adapter3);
                        학교 = 2;
                        break;
                }
            }
             @Override
             public void onNothingSelected(AdapterView<?> parent) {
                list.setAdapter(adapter1);
            }
        });

        final Intent intent = new Intent(getActivity(), FXActivity.class);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (학교) {
                    case 0:
                        intent.putExtra("공식이름", list1[position]);
                        intent.putExtra("공식이미지", Image[position]);
                        break;
                }
                startActivity(intent);
            }
        });

    return view;
    }
}