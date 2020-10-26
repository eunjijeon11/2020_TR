package com.example.mainscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class Quiz_End extends AppCompatActivity {

    int score;
    TextView score_tv;
    int[] ox;
    String file;

    CardView fr1done;

    private RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView recyclerView;

    List<Bitmap> listoxquizid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__end);

        score_tv = (TextView)findViewById(R.id.score);
        recyclerView = findViewById(R.id.recyclerV);
        fr1done = findViewById(R.id.fr1done);

        final Intent quiz_end = getIntent();
        score = quiz_end.getExtras().getInt("점수");
        score_tv.setText(5*score+"점");
        ox = quiz_end.getExtras().getIntArray("ox");
        file = quiz_end.getExtras().getString("파일명");

        try {
            listoxquizid = Arrays.asList(

                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"1.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"2.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"3.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"4.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"5.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"6.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"7.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"8.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"9.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"10.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"11.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"12.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"13.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"14.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"15.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"16.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"17.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"18.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"19.jpg")),
                    BitmapFactory.decodeStream(getResources().getAssets().open("quiz/"+file+"_"+"20.jpg"))

            );
        } catch (Exception e) {
            e.printStackTrace();
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        for (int i=0; i<20; i++) {
            Data data = new Data();

            if(ox[i]==1) {
                data.setoxId(R.drawable.right);
            }
            else if(ox[i]==0) {
                data.setoxId(R.drawable.wrong);
            }
            data.setOxquizId(listoxquizid.get(i));

            recyclerViewAdapter.addItem(data);
        }

        recyclerViewAdapter.notifyDataSetChanged();

        final DBOpenHelper mDbOpenHelper = new DBOpenHelper(this);
        mDbOpenHelper.open();
        final LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);

        fr1done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean sendvalue = mDbOpenHelper.insertColumn(file, score);
                mDbOpenHelper.close();
                Intent broadcastIntent = new Intent();
                broadcastIntent.putExtra("sendvalue", sendvalue);
                lbm.sendBroadcast(broadcastIntent);
                finish();
            }
        });

    }
}
