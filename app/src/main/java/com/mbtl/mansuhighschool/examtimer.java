package com.mbtl.mansuhighschool;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
public class examtimer extends AppCompatActivity {
    LinearLayout timeCountSettingLV, timeCountLV;
    EditText hourET, minuteET, secondET;
    TextView hourTV, minuteTV, secondTV, finishTV;
    Button startBtn, pauseBtn, cancelBtn;
    int hour, minute, second;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.examtimer);
        timeCountSettingLV = (LinearLayout)findViewById(R.id.timeCountSettingLV);
        timeCountLV = (LinearLayout)findViewById(R.id.timeCountLV);
        hourET = (EditText)findViewById(R.id.hourET);
        minuteET = (EditText)findViewById(R.id.minuteET);
        secondET = (EditText)findViewById(R.id.secondET);
        hourTV = (TextView)findViewById(R.id.hourTV);
        minuteTV = (TextView)findViewById(R.id.minuteTV);
        secondTV = (TextView)findViewById(R.id.secondTV);
        finishTV = (TextView)findViewById(R.id.finishTV);
        startBtn = (Button)findViewById(R.id.startBtn);
        pauseBtn = (Button)findViewById(R.id.pauseBtn);
        cancelBtn= (Button)findViewById(R.id.cancelBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeCountSettingLV.setVisibility(View.GONE);
                timeCountLV.setVisibility(View.VISIBLE);
                hourTV.setText(hourET.getText().toString());
                minuteTV.setText(minuteET.getText().toString());
                secondTV.setText(secondET.getText().toString());
                if (TextUtils.isEmpty(hourET.getText())){hour = 0;}
                else{ hour = Integer.parseInt(hourET.getText().toString());}
                if (TextUtils.isEmpty(minuteET.getText())){minute = 0;}
                else{minute = Integer.parseInt(minuteET.getText().toString());}
                if (TextUtils.isEmpty(secondET.getText())){second = 0;}
                else{second = Integer.parseInt(secondET.getText().toString());}
                pauseBtn.setVisibility(View.VISIBLE);
                pauseBtn.setEnabled(true);
                cancelBtn.setVisibility(View.VISIBLE);
                cancelBtn.setEnabled(true);
                startBtn.setVisibility(View.INVISIBLE);
                startBtn.setEnabled(false);
                Handler handler = new Handler(){
                    public void handleMessage(Message msg){
                        if(second != 0) {
                            second--;
                        } else if(minute != 0) {
                            second = 60;
                            second--;
                            minute--;
                        } else if(hour != 0) {
                            second = 60;
                            minute = 60;
                            second--;
                            minute--;
                            hour--;
                        }
                        if(second <= 9){
                            secondTV.setText("0" + second);
                        } else {
                            secondTV.setText(Integer.toString(second));
                        }
                        if(minute <= 9){
                            minuteTV.setText("0" + minute);
                        } else {
                            minuteTV.setText(Integer.toString(minute));
                        }
                        if(hour <= 9){
                            hourTV.setText("0" + hour);
                        } else {
                            hourTV.setText(Integer.toString(hour));
                        }
                        if(hour == 0 && minute == 0 && second == 0) {
                            finishTV.setText("타이머가 종료되었습니다.");
                            pauseBtn.setVisibility(View.INVISIBLE);
                            pauseBtn.setEnabled(false);
                            cancelBtn.setVisibility(View.INVISIBLE);
                            cancelBtn.setEnabled(false);
                            startBtn.setVisibility(View.VISIBLE);
                            startBtn.setEnabled(true);
                        }
                    }
                };
                Timer timer = new Timer(true);
                TimerTask timerTask = new TimerTask(){
                    @Override public void run() {
                        Message msg = handler.obtainMessage();
                        handler.sendMessage(msg);
                    }

                    @Override
                    public boolean cancel() {
                        return super.cancel();
                    }
                };
                timer.schedule(timerTask, 0, 1000);
            }

        });
    }
}