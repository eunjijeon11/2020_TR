package com.example.mainscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class frag4 extends Fragment {

    private View view;
    private TextView tv_pro;
    private TextView name;
    private TextView number;
    private ImageView iv_profile;
    private Bitmap bitmap;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);

        iv_profile = view.findViewById(R.id.profile);
        name = view.findViewById(R.id.name);
        number = view.findViewById(R.id.number);
        tv_pro = view.findViewById(R.id.tv_pro);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        if (!sharedPreferences.getString("username", "").equals("")) {
            name.setText(sharedPreferences.getString("username", ""));
            number.setText(sharedPreferences.getString("usernum", ""));
            String profile = sharedPreferences.getString("image", "");
            try {
                bitmap = BitmapFactory.decodeStream(getActivity().openFileInput(profile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            iv_profile.setImageBitmap(bitmap);
        }

        tv_pro.setOnClickListener(new View.OnClickListener() {
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
                    iv_profile.setImageBitmap(bitmap);

                    editor = sharedPreferences.edit();
                    editor.putString("username", username);
                    editor.putString("usernum", usernum);
                    editor.putString("image", profile);
                    editor.apply();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//editprofile에서 이름, 학번, 이미지 받아옴
}
