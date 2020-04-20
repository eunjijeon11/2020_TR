package com.example.mainscreen;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class frag4 extends Fragment {

    private View view;
    private ImageButton btn_pro;
    private TextView name;
    private TextView number;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);

        name = (TextView) view.findViewById(R.id.name);
        number = (TextView) view.findViewById(R.id.number);
        btn_pro = (ImageButton) view.findViewById(R.id.btn_pro); //UI연결

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

                    name.setText(username);
                    number.setText(usernum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//editprofile에서 이름, 학번, 이미지 받아옴
}
