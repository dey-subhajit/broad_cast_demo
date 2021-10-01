package com.app.broadcastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    IntentFilter ifl;
    BroadcastReceiver bcReciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ifl = new IntentFilter("android.intent.action.BATTERY_OKAY");
        bcReciver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Power connected", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(bcReciver);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(bcReciver, ifl);
    }
}