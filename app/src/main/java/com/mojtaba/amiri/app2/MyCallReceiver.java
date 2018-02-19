package com.mojtaba.amiri.app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

public class MyCallReceiver extends BroadcastReceiver {

    public static TextView textView;


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
            String savedNumber = intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");
        }
        else{
            String stateStr = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
        }


    }
}
