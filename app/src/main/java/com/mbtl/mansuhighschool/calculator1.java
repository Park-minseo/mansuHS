package com.mbtl.mansuhighschool;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculator1 extends AppCompatActivity{

    ImageView math1,math2,math3;
    EditText input;
    TextView textview3;
    int a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator1);

        math1 = findViewById(R.id.math1);
        math2 = findViewById(R.id.math2);
        math3 = findViewById(R.id.math3);

        input = findViewById(R.id.input);
        textview3 = findViewById(R.id.textView3);

        math1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                a = Integer.parseInt(input.getText().toString());
                b = a*(a+1)/2;

                textview3.setText(String.valueOf(b));
            }
        });
        math2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                a = Integer.parseInt(input.getText().toString());
                b = a*(a+1)*(a*2+1)/6;

                textview3.setText(String.valueOf(b));
            }
        });
        math3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                a = Integer.parseInt(input.getText().toString());
                b = a*(a+1)/2;
                c = b*b;

                textview3.setText(String.valueOf(c));
            }
        });
    }
}