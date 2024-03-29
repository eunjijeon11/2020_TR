package com.example.mainscreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements communicator{

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private frag1 frag1;
    private frag2 frag2;
    private frag3 frag3;
    private frag4 frag4;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //frag1,3에 신호 보내기
            Log.e("localBC", "success");
            respond("receiveData");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBOpenHelper mDbOpenHelper = new DBOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();
        mDbOpenHelper.close();

        IntentFilter intentFilter = new IntentFilter("localBC");
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.Learn:
                        setFrag(0);
                        break;
                    case R.id.Book:
                        setFrag(1);
                        break;
                    case R.id.graph:
                        setFrag(2);
                        break;
                    case R.id.mypage:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });
        frag1 = new frag1();
        frag2 = new frag2();
        frag3 = new frag3();
        frag4 = new frag4();

        setFrag(0);

    }

    private void setFrag(int n) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (n) {
            case 0:
                fragmentTransaction.replace(R.id.frame, frag1);
                fragmentTransaction.commit();
                break;
            case 1:
                fragmentTransaction.replace(R.id.frame, frag2);
                fragmentTransaction.commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.frame, frag3);
                fragmentTransaction.commit();
                break;
            case 3:
                fragmentTransaction.replace(R.id.frame, frag4);
                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    public void respond(String data) {
        frag1.updateProgress();
    }
}
