package com.mbtl.mansuhighschool;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class calculator2 extends AppCompatActivity{

    TextView log,answer;
    ImageView ax;
    EditText input_value1,input_value2;
    int a,b,c,d=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator2);

        log = findViewById(R.id.log);
        answer = findViewById(R.id.answer);
        ax = findViewById(R.id.ax);
        input_value1 = findViewById(R.id.input_value1);
        input_value2 = findViewById(R.id.input_value2);

        log.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                a = Integer.parseInt(input_value1.getText().toString());
                b = Integer.parseInt(input_value2.getText().toString());
                c = b%a;
                while(c == 0)
                {
                    b = b/a;
                    c = b%a;
                    d = d+1;
                }
                answer.setText(String.valueOf(d));
            }
        });
        ax.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                a = Integer.parseInt(input_value1.getText().toString());
                b = Integer.parseInt(input_value2.getText().toString());
                c = a;
                while(b > 1)
                {
                    b = b-1;
                    a = a*c;
                }
                answer.setText(String.valueOf(a));
            }
        });
    }
}