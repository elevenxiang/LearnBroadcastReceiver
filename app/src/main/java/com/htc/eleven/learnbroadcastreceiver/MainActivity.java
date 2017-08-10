package com.htc.eleven.learnbroadcastreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText tv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnSendMsg).setOnClickListener(this);

        tv = (EditText) findViewById(R.id.tv);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSendMsg:
                Intent intent = new Intent(MainActivity.this,MyReceiver.class);
                intent.putExtra("data", "来自eleven的广播数据: " + tv.getText().toString());
                sendBroadcast(intent);
                break;
        }
    }
}
