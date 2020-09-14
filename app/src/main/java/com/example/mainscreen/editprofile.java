package com.example.mainscreen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class editprofile extends AppCompatActivity {

    Button btn_savepro;
    Button btn_changepro;
    EditText name;
    EditText number;
    String username;
    String usernum;
    ImageView profile;
    private static final int REQUEST_CODE = 0;

    Bitmap img;
    String profilename;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile);

        final Intent intent = getIntent();

        btn_savepro = (Button) findViewById(R.id.btn_savepro);
        btn_changepro = (Button) findViewById(R.id.btn_changepro);
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
        profile = (ImageView) findViewById(R.id.profile); //UI연결

        btn_changepro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prointent = new Intent();
                prointent.setType("image/*");
                prointent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(prointent, REQUEST_CODE);
            }
        }); //프사 바꾸기 버튼을 누르면 Intent를 통해 갤러리로 넘어감

        btn_savepro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = name.getText().toString();
                usernum = number.getText().toString();
                intent.putExtra("username", username);
                intent.putExtra("usernum", usernum);
                intent.putExtra("profile_img", createImageFromBitmap(img));

                setResult(1000, intent);
                finish();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE) {

            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    img = BitmapFactory.decodeStream(in);
                    in.close();

                    profile.setImageBitmap(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } //이미지를 받아서 bitmap 형식으로 전환, 이미지뷰에 사진 넣기.
            else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            } //사진 선택하다가 뒤로가기 누르면 토스트 띄우기
        }
    }

    public String createImageFromBitmap(Bitmap bitmap) {
        String filename = "profileImg";
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            FileOutputStream fo = openFileOutput(filename, Context.MODE_PRIVATE);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (Exception e) {
            e.printStackTrace();
            filename = null;
        }
        return filename;
    }

}
