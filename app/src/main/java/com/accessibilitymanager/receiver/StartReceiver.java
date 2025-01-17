package com.accessibilitymanager.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;

import com.accessibilitymanager.service.DaemonService;

public class StartReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("data", 0);
        if (sharedPreferences.getBoolean("boot",true))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                context.startForegroundService(new Intent(context, DaemonService.class));
            else
                context.startService(new Intent(context, DaemonService.class));
    }
}
