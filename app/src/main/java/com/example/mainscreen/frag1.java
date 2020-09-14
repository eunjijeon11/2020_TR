package com.example.mainscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class frag1 extends Fragment {

    private View view;

    private CardView e1, e2, e3, m1, m2, m3, m4, h1, h2, h3, h4;
    private String[] content;
    private int d;

    int progress = 0;
    int correct_rate = 0;
    ProgressBar progress_pb, correct_rate_pb;
    TextView progress_t, correct_rate_t;

    int score_sum = 0;
    int complete_session = 0;
    String[] filename;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SharedPreferences.OnSharedPreferenceChangeListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

        e1 = (CardView) view.findViewById(R.id.sachic);
        e2 = (CardView) view.findViewById(R.id.bunsu);
        e3 = (CardView) view.findViewById(R.id.sosu);
        m1 = (CardView) view.findViewById(R.id.jungsu);
        m2 = (CardView) view.findViewById(R.id.yeonb);
        m3 = (CardView) view.findViewById(R.id.root);
        m4 = (CardView) view.findViewById(R.id.insu);
        h1 = (CardView) view.findViewById(R.id.dahang);
        h2 = (CardView) view.findViewById(R.id.namugi);
        h3 = (CardView) view.findViewById(R.id.log);
        h4 = (CardView) view.findViewById(R.id.jisu);

        progress_pb = (ProgressBar) view.findViewById(R.id.progressbar1);
        correct_rate_pb = (ProgressBar) view.findViewById(R.id.progressbar2);
        progress_t = (TextView) view.findViewById(R.id.progress_t);
        correct_rate_t = (TextView) view.findViewById(R.id.correct_rate_t);

        progress_pb.setProgress(progress);
        correct_rate_pb.setProgress(correct_rate);
        progress_t.setText("학습 진도: " + progress + "%");
        correct_rate_t.setText("정답률: " + correct_rate + "%");

        content = getResources().getStringArray(R.array.small_unit);
        filename = getResources().getStringArray(R.array.filename);

        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=0;
                Intent intent = new Intent(getActivity(), content.class);
                intent.putExtra("단원명","사칙연산");
                intent.putExtra("소단원명1",content[d]);
                intent.putExtra("소단원명2",content[d+1]);
                intent.putExtra("소단원명3",content[d+2]);
                startActivity(intent);
            }
        });

        // TODO: 2020-09-07 나중에 시간되면 고치기:(
        /*listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                if(key.endsWith("_b") || key.endsWith("_s")) {
                    complete_session = 0;
                    score_sum = 0;
                    for (int i=0; i<11; i++) {
                        if (sharedPreferences.getBoolean(filename[i] + "_b", false) == true) {
                            complete_session += 1;
                        }
                        score_sum += sharedPreferences.getInt(filename[i] + "_s", 0);
                    }

                    progress = complete_session / 11 * 100;
                    correct_rate = score_sum / (complete_session * 20) * 100;
                    progress_pb.setProgress(progress);
                    correct_rate_pb.setProgress(correct_rate);
                    progress_t.setText("학습 진도: " + progress + "%");
                    correct_rate_t.setText("정답률: " + correct_rate + "%");

                    editor.putInt("progress", progress);
                    editor.putInt("correct_rate", correct_rate);
                    editor.apply();
                }
            }
        };

        sharedPreferences.registerOnSharedPreferenceChangeListener(listener);*/

        return view;
    }
}