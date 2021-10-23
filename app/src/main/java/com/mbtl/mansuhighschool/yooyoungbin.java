package com.mbtl.mansuhighschool;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class yooyoungbin extends AppCompatActivity {

    int i = 1;
    public void print(){
        Toast.makeText(getApplicationContext(), "이동할 수 없습니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yooyoungbin);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);//핸드폰이 다크모드여도 앱 배경 안변하게 함


        Button up = findViewById(R.id.up);
        Button right = findViewById(R.id.right);
        Button down = findViewById(R.id.down);
        Button left = findViewById(R.id.left);
        ImageView img = (ImageView)findViewById(R.id.image);
        int[] images = new int[26];
        images[1] = R.drawable.m1;
        images[2] = R.drawable.m2;
        images[3] = R.drawable.m3;
        images[4] = R.drawable.m4;
        images[5] = R.drawable.m5;
        images[6] = R.drawable.m6;
        images[7] = R.drawable.m7;
        images[8] = R.drawable.m8;
        images[9] = R.drawable.m9;
        images[10] = R.drawable.m10;
        images[11] = R.drawable.m11;
        images[12] = R.drawable.m12;
        images[13] = R.drawable.m13;
        images[14] = R.drawable.m14;
        images[15] = R.drawable.m15;
        images[16] = R.drawable.m16;
        images[17] = R.drawable.m17;
        images[18] = R.drawable.m18;
        images[19] = R.drawable.m19;
        images[20] = R.drawable.m20;
        images[21] = R.drawable.m21;
        images[22] = R.drawable.m22;
        images[23] = R.drawable.m23;
        images[24] = R.drawable.m24;
        images[25] = R.drawable.m25;

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m = i % 6;
                if(m != 0){
                    if(i==25){
                        print();
                    }
                    else{
                        i += 1;
                        img.setImageResource(images[i]);
                    }
                }
                else if(i == 18){
                    i += 1;
                    img.setImageResource(images[i]);
                }
                else if(i == 24) {
                    i += 1;
                    img.setImageResource(images[i]);
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
                        img.setImageResource(images[i]);
                        Log.i("d", "" + i);
                    }
                }
                else if(i == 19){
                    i -= 1;
                    img.setImageResource(images[i]);
                }
                else if(i == 25) {
                    i -= 1;
                    img.setImageResource(images[i]);
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
                    img.setImageResource(images[i]);
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
                        img.setImageResource(images[i]);
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



    }
}