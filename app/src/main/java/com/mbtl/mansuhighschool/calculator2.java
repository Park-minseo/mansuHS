package com.mbtl.mansuhighschool;

import android.os.Bundle;
import android.view.View;
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