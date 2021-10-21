package com.mbtl.mansuhighschool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class m7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yooyoungbin);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);//핸드폰이 다크모드여도 앱 배경 안변하게 함

        Button upward = findViewById(R.id.upward);
        Button direction_right = findViewById(R.id.direction_right);
        Button direction_left = findViewById(R.id.direction_left);

        upward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), m8.class);
                startActivity(intent);

            }
        });

        direction_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), m13.class);
                startActivity(intent);
            }
        });

        direction_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), yooyoungbin.class);
                startActivity(intent);
            }
        });
    }
}