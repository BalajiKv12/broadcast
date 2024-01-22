package com.example.broadcas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class reciever extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String a = intent.getAction();
        if(a.equals("com.example.BALAJI_KV")) {
            Toast.makeText(context, "Custom message received", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(context,MainActivity2.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
       else if (isAirplaneModeOn(context.getApplicationContext())) {
            Toast.makeText(context, "AirPlane mode is on", Toast.LENGTH_SHORT).show();
        } else if(!isAirplaneModeOn(context.getApplicationContext())){
            Toast.makeText(context, "AirPlane mode is off", Toast.LENGTH_SHORT).show();
        }
    }

    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }
    }
