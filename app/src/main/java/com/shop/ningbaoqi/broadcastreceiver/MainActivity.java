package com.shop.ningbaoqi.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 动态注册广播 只有执行了 onCreate 方法，才能注册该广播
         * */
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("dashuige");
        receiver = new MyReceiver();
        registerReceiver(receiver, intentFilter);
    }

    private MyReceiver receiver;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 取消注册
         * */
        unregisterReceiver(receiver);
    }

    public void sendNormalBroadcast(View view) {
        Intent intent = new Intent();
        intent.putExtra("msg", "normal broadcast");
        intent.setAction("dashuige");
        intent.setFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }

    public void sendOrderBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction("order");
        /**
         * 发送有序广播，广播接收器将会按照优先级依次收到广播，并且可以拦截广播
         * 普通广播是异步的，在同一时刻所有广播接收器都能接收到，消息传递效率比较高，缺点是无法终止广播传播
         * */
        sendOrderedBroadcast(intent, null, new MyReceiver(), null, 0, null, null);
    }

    /**
     * 最终广播接收器,并且在广播传递过程中最后收到，无论广播是不是被拦截，都会收到，不需要在清单文件中配置，该广播接收器只接收该广播
     */
    class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg = intent.getStringExtra("msg");
            Log.d("nbq", "msh : " + msg);
            /**
             * 阻止广播向其他广播接收器传递,只能阻止有序广播
             * */
            abortBroadcast();
        }
    }
}
