package com.example.mainscreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Data> items = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ox;
        ImageView ox_quiz;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ox = itemView.findViewById(R.id.ox);
            ox_quiz = itemView.findViewById(R.id.ox_quiz);
        }

        void onbind(Data data) {
            ox.setImageResource(data.getoxId());
            ox_quiz.setImageBitmap(data.getoxquizId());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ox_recyclerview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

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
