package com.htc.eleven.learnbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AnotherReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("AnotherReceiver: 收到的消息是: " + intent.getStringExtra("data"));

        // when call below one, other low-priority BroadcastReceiver can't get broadcast message anymore.
        abortBroadcast();

    }
}
