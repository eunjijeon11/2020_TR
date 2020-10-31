package com.example.mainscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class frag4 extends Fragment {

    private View view;
    private ImageButton btn_pro;
    private TextView name;
    private TextView number;
    private ImageView profile_iv;
    private Bitmap bitmap;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private BroadcastReceiver mLocalReceiver;
    private static final String LOCAL_BROADCAST_ACTION = "localBroadcastReceiver";

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);

        profile_iv = view.findViewById(R.id.profile);
        name = (TextView) view.findViewById(R.id.name);
        number = (TextView) view.findViewById(R.id.number);
        btn_pro = (ImageButton) view.findViewById(R.id.btn_pro); //UI연결

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        editor = sharedPreferences.edit();

        if (!sharedPreferences.getString("username", "").equals("")) {
            name.setText(sharedPreferences.getString("usernum", ""));
            number.setText(sharedPreferences.getString("usernum", ""));
        }

        btn_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), editprofile.class);
                    startActivityForResult(intent, 1000);
            }
        }); //버튼 누르면 editprofile 화면으로 넘어감

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000) {
            if (resultCode == 1000) {
                try {
                    String username = data.getStringExtra("username");
                    String usernum = data.getStringExtra("usernum");
                    String profile = data.getStringExtra("profile_img");

                    bitmap = BitmapFactory.decodeStream(getActivity().openFileInput(profile));

                    name.setText(username);
                    number.setText(usernum);
                    profile_iv.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//editprofile에서 이름, 학번, 이미지 받아옴

    @Override
    public void onResume() {
        super.onResume();
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFilter = new IntentFilter(LOCAL_BROADCAST_ACTION);
        mLocalReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                name.setText("success");
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
