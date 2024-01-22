package com.example.broadcas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button broad;
    BroadcastReceiver receiver = new reciever();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        broad=findViewById(R.id.broad);
        String as = "com.example.BALAJI_KV";
        IntentFilter filter = new IntentFilter();
        filter.addAction(as);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        getApplicationContext().registerReceiver(receiver,filter,Context.RECEIVER_NOT_EXPORTED);
        broad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setPackage("com.example.broadcas");
                i.setAction(as);
                sendBroadcast(i);
            }
        });
    }

}