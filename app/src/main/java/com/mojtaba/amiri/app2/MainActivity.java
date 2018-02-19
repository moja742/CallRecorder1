package com.mojtaba.amiri.app2;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;

    private Context mContext;
    private MyCallReceiver callReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=this;
        tv1=findViewById(R.id.tv1);
        MyCallReceiver.textView=tv1;

        getPermission();

    }

    private void getPermission() {
        if(ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE},0);
        }
        if(ContextCompat.checkSelfPermission(mContext, Manifest.permission.PROCESS_OUTGOING_CALLS)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS},0);
        }
        if(ContextCompat.checkSelfPermission(mContext, Manifest.permission.RECORD_AUDIO)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECORD_AUDIO},0);
        }


    }


}
