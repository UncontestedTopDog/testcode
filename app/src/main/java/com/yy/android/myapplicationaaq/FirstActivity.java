package com.yy.android.myapplicationaaq;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.yy.android.myapplicationaaq.anr.ANRActivity;
import com.yy.android.myapplicationaaq.blockcanary.BlockCanaryActivity;
import com.yy.android.myapplicationaaq.databinding.ActivityFirst2Binding;
import com.yy.android.myapplicationaaq.databinding.DataBindingActivity;
import com.yy.android.myapplicationaaq.handler.HandlerActivity;
import com.yy.android.myapplicationaaq.leakcanary.TestLeak;
import com.yy.android.myapplicationaaq.thread.ThreadActivity;
import com.yy.android.myapplicationaaq.touch.TouchActivity;
import com.yy.android.myapplicationaaq.web.NativeWebView;
import com.yy.android.myapplicationaaq.web.WebActivity;

import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;

public class FirstActivity extends Activity {

    ActivityFirst2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first2);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first2);
        binding.nextActivity.setOnClickListener(v -> {
            // Intent intent = new Intent(FirstActivity.this, RetrofitActivity.class);
            // Intent intent = new Intent(FirstActivity.this, TestDataActivity.class);
            // Intent intent = new Intent(FirstActivity.this, GoodsActivity.class);
            // Intent intent = new Intent(FirstActivity.this, DataBindingActivity.class);
            // Intent intent = new Intent(FirstActivity.this, LifecycleActivity.class);
            // Intent intent = new Intent(FirstActivity.this, ArouterOneActivity.class);
            // Intent intent = new Intent(FirstActivity.this, TouchActivity.class);
            // Intent intent = new Intent(FirstActivity.this, HandlerActivity.class);
            // Intent intent = new Intent(FirstActivity.this, ThreadActivity.class);
            Intent intent = new Intent(FirstActivity.this, ANRActivity.class);
            // Intent intent = new Intent(FirstActivity.this, GlideActivity.class);
            // Intent intent = new Intent(FirstActivity.this, FragmentActivity.class);
            // Intent intent = new Intent(FirstActivity.this, ViewModelActivity.class);
            // Intent intent = new Intent(FirstActivity.this, LeakCanaryActivity.class);
            // Intent intent = new Intent(FirstActivity.this, BlockCanaryActivity.class);
            // Intent intent = new Intent(FirstActivity.this, WebActivity.class);
            // Intent intent = new Intent(FirstActivity.this, MemoryStaticActivity.class);
            // Intent intent = new Intent(FirstActivity.this, ArouterServiceActivity.class);
            startActivity(intent);
        });

        binding.init.setOnClickListener(v->{
            // TestInstance.getInstance().setActivity(null);
            // TestLeak.getInstance().clear();
            // TestLeak.getInstance().setVb(null);
            // System.gc();
            // String[] PERMISSION = {Manifest.permission.READ_PHONE_STATE};
            // ActivityCompat.requestPermissions(this, PERMISSION, 0x12);

            // Log.i("NativeWebView","OnClick");
            // NativeWebView webView = new NativeWebView(FirstActivity.this);
            // webView.loadUrl("http://m.100.com/?source=119");
            // addContentView(webView, new  ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            //         ViewGroup.LayoutParams.MATCH_PARENT));

            Log.i("AAAAAA","AAAAAA1");
        });

        binding.cicularImageView.setImageResource(R.drawable.test);

        Looper.getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                Log.i("AAAAAA","AAAAAA1");
                return true;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}