package com.mojtaba.amiri.app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MyCallReceiver extends BroadcastReceiver {

    public static TextView textView;


    @Override
    public void onReceive(Context context, Intent intent) {


        if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
            String savedNumber = intent.getExtras().getString("android.intent.extra.PHONE_NUMBER");

        }
        else if(intent.getAction().equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)){
            String stateStr = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
            String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context,stateStr,Toast.LENGTH_LONG).show();
            Toast.makeText(context,number,Toast.LENGTH_LONG).show();
            if(stateStr.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
                try {
                    MediaRecorder recorder = new MediaRecorder();
                    recorder.setAudioSource(MediaRecorder.AudioSource.VOICE_CALL);
                    recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    if (isExternalStorageWritable()) {
                        File file=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                        recorder.setOutputFile(file.getPath());
                        recorder.prepare();
                        recorder.start();   // Recording is now started
                    }
                }catch (IOException ex){ex.printStackTrace();}

            }
        }
        else{
            Toast.makeText(context,"Error Happened",Toast.LENGTH_LONG).show();
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

}
