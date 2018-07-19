package com.shop.ningbaoqi.broadcastreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNormalBroadcast(View view) {
        Intent intent = new Intent();
        intent.putExtra("msg", "normal broadcast");
        intent.setAction("dashuige");
        intent.setFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }
}
