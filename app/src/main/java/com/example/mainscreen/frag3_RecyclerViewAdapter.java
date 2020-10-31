package com.example.mainscreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class frag3_RecyclerViewAdapter extends RecyclerView.Adapter<frag3_RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Data> items = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_unit, tv_quizDate, tv_quizScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_unit = itemView.findViewById(R.id.tv_unit);
            tv_quizDate = itemView.findViewById(R.id.tv_quizDate);
            tv_quizScore = itemView.findViewById(R.id.tv_quizScore);
        }

        void onbind(Data data) {
            tv_unit.setText(data.getUnit());
            tv_quizDate.setText(data.getQuizDate());
            String score = data.getQuizScore() + "점";
            tv_quizScore.setText(score);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.analyze_recyclerview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull frag3_RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.onbind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    void addItem(Data data) {
        items.add(data);
    }
}
