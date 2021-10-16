package com.mbtl.mansuhighschool;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_option, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                Intent intent = new Intent(getApplicationContext(), dev.class);
                startActivity(intent);

                AlertDialog alertDialog = builder.create();

                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ImageButton button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), parkminseo.class);
                startActivity(intent);
            }
        });

        ImageButton button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), leejaewoo.class);
                startActivity(intent);
            }
        });

        ImageButton button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), choisoonjoo.class);
                startActivity(intent);
            }
        });

        ImageButton button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), yooyoungbin.class);
                startActivity(intent);
            }
        });

        ImageButton button5=findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), leechanyoung.class);
                startActivity(intent);
            }
        });
        ImageButton button6=findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), jungtaehyun.class);
                startActivity(intent);
            }
        });

    }
}