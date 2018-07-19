package com.shop.ningbaoqi.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootRunReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent();
        intent1.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }
}