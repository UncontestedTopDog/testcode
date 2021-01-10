package com.yy.android.myapplicationaaq.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.yy.android.myapplicationaaq.R;

public class ThreadActivity extends AppCompatActivity {
    Handler handler2;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        textView = findViewById(R.id.text);
        new Thread(new Runnable() {
            @Override
            public void run() {
                textView.setText("AAAAAAAA");
            }
        }).start();
        findViewById(R.id.test).setOnClickListener(v->{
            // int i = 0;
            // while (i < 10000) {
            //     int finalI = i;
            //     Thread thread = new Thread(new Runnable() {
            //         @Override
            //         public void run() {
            //             System.out.println("AAAAAAAA"+ finalI);
            //             try {
            //                 Thread.sleep(100*10000);
            //             } catch (InterruptedException e) {
            //                 e.printStackTrace();
            //             }
            //         }
            //     });
            //     thread.start();
            //     i++;
            // }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Looper.prepare();
                    Log.i("AAAAAA2","AAAAAAAAAAAAC");
                    Looper.loop();
                }
            }).start();
        });
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }

}