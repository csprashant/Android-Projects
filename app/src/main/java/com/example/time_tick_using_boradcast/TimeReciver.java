package com.example.time_tick_using_boradcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class TimeReciver  extends BroadcastReceiver {
    TextView h,m;
    public TimeReciver(TextView h,TextView m) {
        this.h=h;
        this.m=m;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
            if(intent.getAction().compareTo(Intent.ACTION_TIME_TICK)==0) {
                h.setText(String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)));
                m.setText(String.valueOf(Calendar.getInstance().get(Calendar.MINUTE)));
            }
    }
}
