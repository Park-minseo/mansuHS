package com.mbtl.mansuhighschool;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculator2 extends AppCompatActivity{

    TextView log,answer,jisu;
    EditText input_value1,input_value2;

    int a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator2);

        log = findViewById(R.id.log);
        jisu = findViewById(R.id.jisu);
        answer = findViewById(R.id.answer);
        input_value1 = findViewById(R.id.input_value1);
        input_value2 = findViewById(R.id.input_value2);


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                a = Integer.parseInt(input_value1.getText().toString());
                b = Integer.parseInt(input_value2.getText().toString());
                c = 1;
                while(a != b)
                {
                    c = c+1;
                    a = a*a;
                }
                answer.setText(String.valueOf(c));
            }
        });
        jisu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                a = Integer.parseInt(input_value1.getText().toString());
                b = Integer.parseInt(input_value2.getText().toString());
                c = a;
                while(b != 1)
                {
                    a = a*c;
                    b = b-1;
                }
                answer.setText(String.valueOf(a));
            }
        });
    }
}