package com.yy.android.myapplicationaaq.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Button;

import com.yy.android.myapplicationaaq.R;

public class HandlerActivity extends AppCompatActivity {

    private int i = 0;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Log.i("HandlerActivityMessage","   BBBBA "+msg.arg1);
            return false;
        }
    }) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Log.i("HandlerActivityMessage","   BBBBC "+msg.arg1);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ((Button)findViewById(R.id.send)).setText("aaa");
        // findViewById(R.id.send).setOnClickListener(v->{
        //     while (i < 10) {
        //         send(i);
        //         i++;
        //     }
        //     handler.post(new Runnable() {
        //         @Override
        //         public void run() {
        //             Log.i("HandlerActivityMessage","   CCC ");
        //         }
        //     });
        // });
        // HandlerThread handlerThread = new HandlerThread("handlerThread");
        // handlerThread.start();
        // Handler handler = new Handler(handlerThread.getLooper()) {
        //     @Override
        //     public void handleMessage(@NonNull Message msg) {
        //         super.handleMessage(msg);
        //         System.out.println(msg.what+"   XXXXXXXXXXX   "+msg.obj);
        //     }
        // };
        // Message message = Message.obtain();
        // message.what = 2;
        // message.obj = "B";
        // handler.sendMessage(message);
        // handlerThread.quit();


        findViewById(R.id.send).setOnClickListener(v->{
            Message message = Message.obtain();
            message.what = 2;
            message.obj = "B";
            message.setAsynchronous(true);
            handler.sendMessage(message);
        });

    }

    private void send(int i) {
        Message message = Message.obtain();
        message.arg1 = i;
        handler.sendMessage(message);
        Message msg = handler.obtainMessage();
        msg.arg1 = i*20;
        msg.setAsynchronous(true);
        handler.sendMessage(msg);
    }
}