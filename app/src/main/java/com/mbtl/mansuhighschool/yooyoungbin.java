package com.mbtl.mansuhighschool;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.bumptech.glide.Glide;

public class yooyoungbin extends AppCompatActivity {

    int i = 1;
    public void print(){
        Toast.makeText(getApplicationContext(), "이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
    }

    ImageView imageview, ima;
    String imgUrl = "https://i.ibb.co/4TVZNM3/s1.png";
    Bitmap bmImg;
    int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yooyoungbin);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);//핸드폰이 다크모드여도 앱 배경 안변하게 함


        Button up = findViewById(R.id.up);
        Button right = findViewById(R.id.right);
        Button down = findViewById(R.id.down);
        Button left = findViewById(R.id.left);
        imageview =  (ImageView) findViewById(R.id.image);
        ima = (ImageView) findViewById(R.id.image1);
        Display display = getWindowManager().getDefaultDisplay();  // in Activity
        /* getActivity().getWindowManager().getDefaultDisplay() */ // in Fragment
        Point size = new Point();
        display.getRealSize(size); // or getSize(size)
        width = size.x;
        height = size.y;

        ima.setVisibility(View.INVISIBLE);
        String[] images=new String[26];
        images[1] = "https://i.ibb.co/gFB2CkS/m1.jpg";
        images[2] = "https://i.ibb.co/T2WGD9f/m2.jpg";
        images[3] = "https://i.ibb.co/r7K268P/m3.jpg";
        images[4] = "https://i.ibb.co/z5DRpnG/m4.jpg";
        images[5] = "https://i.ibb.co/pXp0xsS/m5.jpg";
        images[6] = "https://i.ibb.co/jhxqzLr/m6.jpg";
        images[7] = "https://i.ibb.co/5W5vKy1/m7.jpg";
        images[8] = "https://i.ibb.co/YDPrNFv/m8.jpg";
        images[9] = "https://i.ibb.co/17FZcVv/m9.jpg";
        images[10] = "https://i.ibb.co/9bHqZ5C/m10.jpg";
        images[11] = "https://i.ibb.co/7yfQp2n/m11.jpg";
        images[12] = "https://i.ibb.co/34GvG3G/m12.jpg";
        images[13] = "https://i.ibb.co/p367Xcp/m13.jpg";
        images[14] = "https://i.ibb.co/VmtXw4D/m14.jpg";
        images[15] = "https://i.ibb.co/HhD66CV/m15.jpg";
        images[16] = "https://i.ibb.co/86JyrCd/m16.jpg";
        images[17] = "https://i.ibb.co/1nVvhbt/m17.jpg";
        images[18] = "https://i.ibb.co/zNyYrCr/m18.jpg";
        images[19] = "https://i.ibb.co/vBJSwLv/m19.jpg";
        images[20] = "https://i.ibb.co/m8FR4Ky/m20.jpg";
        images[21] = "https://i.ibb.co/nkGcJVs/m21.jpg";
        images[22] = "https://i.ibb.co/zf3vQQr/m22.jpg";
        images[23] = "https://i.ibb.co/ZxyFbtQ/m23.jpg";
        images[24] = "https://i.ibb.co/nb48FXn/m24.jpg";
        images[25] = "https://i.ibb.co/K7fCc8s/m25.jpg";



        Glide.with(yooyoungbin.this).load(images[1]).into(imageview);

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m = i % 6;
                if(m != 0){
                    if(i==25){

                    }
                    else{
                        i += 1;
                        Glide.with(yooyoungbin.this).load(images[i]).override(1280, 720).into(imageview);
                    }
                }
                else if(i == 18){
                    i += 1;
                    Glide.with(yooyoungbin.this).load(images[i]).override(1280, 720).into(imageview);
                }
                else if(i == 24) {
                    i += 1;
                    Glide.with(yooyoungbin.this).load(images[i]).override(1280, 720).into(imageview);
                }
                else{
                    Toast.makeText(getApplicationContext(), "이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m = i % 6;
                if(m != 1){
                    if(i==1){
                        Toast.makeText(getApplicationContext(), "이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                    else if(i==13){
                        Toast.makeText(getApplicationContext(), "이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                    else if(i==7){
                        Toast.makeText(getApplicationContext(), "이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        i -= 1;
                        Glide.with(yooyoungbin.this).load(images[i]).override(1280, 720).into(imageview);
                        Log.i("d", "" + i);
                    }
                }
                else if(i == 19){
                    i -= 1;
                    Glide.with(yooyoungbin.this).load(images[i]).override(1280, 720).into(imageview);
                }
                else if(i == 25) {
                    i -= 1;
                    Glide.with(yooyoungbin.this).load(images[i]).override(1280, 720).into(imageview);
                }
                else{
                    Toast.makeText(getApplicationContext(), "이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i <=12){
                    i += 6;
                    Glide.with(yooyoungbin.this).load(images[i]).override(1280, 720).into(imageview);
                    Log.i("d",""+i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i>=7){
                    if(i<=18){
                        i -= 6;
                        Glide.with(yooyoungbin.this).load(images[i]).override(1280, 720).into(imageview);
                        Log.i("d",""+i);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }}

