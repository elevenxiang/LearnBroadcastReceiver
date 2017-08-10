package com.htc.eleven.learnbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    public static final String ACTION = "com.htc.eleven.learnbroadcastreceiver.MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("MyReceiver 接收到的消息是: " + intent.getStringExtra("data"));

        // when call below one, other low-priority BroadcastReceiver can't get broadcast message anymore.
        abortBroadcast();
    }
}
