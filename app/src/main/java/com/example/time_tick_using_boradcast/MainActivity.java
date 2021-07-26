package com.example.time_tick_using_boradcast;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TimeReciver timeReciver;
    TextView hourText, minuteText;
          @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hourText=findViewById(R.id.timeTxt);
        minuteText=findViewById(R.id.textView1);

        hourText.setText(String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)));
        minuteText.setText(String.valueOf(Calendar.getInstance().get(Calendar.MINUTE)));

        timeReciver=new TimeReciver(hourText,minuteText);
        registerReceiver(timeReciver,new IntentFilter(Intent.ACTION_TIME_TICK));
        }
    @Override
    protected void onStop() {
        super.onStop();
        if(timeReciver!=null)
        unregisterReceiver(timeReciver);
    }

}