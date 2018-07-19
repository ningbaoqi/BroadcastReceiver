package com.shop.ningbaoqi.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class LocalBroadcastReceiver extends AppCompatActivity {
    private LocalBroadcastManager manager;
    private LocalReceiver receiver;

    /**
     * 本地广播，只能在本应用内部进行传递，并且广播接收器只能接收来自本应用程序发出的广播，本地广播接收器不能进行静态注册，发送本地广播更加有效
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = LocalBroadcastManager.getInstance(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("ningbaoqi");
        receiver = new LocalReceiver();
        manager.registerReceiver(receiver, filter);
        Intent intent = new Intent();
        intent.setAction("ningbaoqi");
        manager.sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.unregisterReceiver(receiver);
    }

    class LocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("nbq", intent.getAction());
        }
    }
}