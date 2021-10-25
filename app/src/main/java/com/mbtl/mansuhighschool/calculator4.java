package com.mbtl.mansuhighschool;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculator4 extends AppCompatActivity{

    Button tool;
    TextView output;
    EditText input1,input2,input3,input4;
    int a,b,c,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator4);

        input1 = findViewById(R.id.innumber1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        input4 = findViewById(R.id.input4);
        tool = findViewById(R.id.tool);
        output = findViewById(R.id.output);

        tool.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                a = Integer.parseInt(input1.getText().toString());
                b = Integer.parseInt(input2.getText().toString());
                c = Integer.parseInt(input3.getText().toString());
                d = Integer.parseInt(input4.getText().toString());
                a = a * 4;
                b = b * 3;
                c = c * 2;
                d = d;
                output.setText(String.valueOf(a)+"X³ +" + String.valueOf(b)+"X² +" + String.valueOf(c)+"X +" + String.valueOf(d));
            }
        });
    }
}