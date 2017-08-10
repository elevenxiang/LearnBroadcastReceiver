package com.htc.eleven.learnbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText tv = null;

    private BroadcastReceiver myReceiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSendMsg).setOnClickListener(this);
        findViewById(R.id.btnRegister).setOnClickListener(this);
        findViewById(R.id.btnUnregister).setOnClickListener(this);

        tv = (EditText) findViewById(R.id.tv);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSendMsg:
                //Intent intent = new Intent(MainActivity.this,MyReceiver.class);
                Intent intent = new Intent(MyReceiver.ACTION);
                intent.putExtra("data", "来自eleven的广播数据: " + tv.getText().toString());
                sendBroadcast(intent);
                break;
            case R.id.btnRegister:
                if(myReceiver == null){
                    myReceiver = new MyReceiver();
                    registerReceiver(myReceiver, new IntentFilter(MyReceiver.ACTION));
                }
                break;
            case R.id.btnUnregister:
                if(myReceiver != null) {
                    unregisterReceiver(myReceiver);
                    myReceiver = null;
                }
                break;

        }
    }
}
