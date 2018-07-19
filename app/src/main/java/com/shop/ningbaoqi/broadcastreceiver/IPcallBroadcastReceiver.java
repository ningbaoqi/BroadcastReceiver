package com.shop.ningbaoqi.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class IPcallBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        /**
         *  打电话广播中，会携带拨打的电话的号码，通过以下api获得
         * */
        String number = getResultData();
        String IPnumber = "0419" + number;
        /**
         * 把新的号码重新放到广播中
         * */
        setResultData(IPnumber);
    }
}