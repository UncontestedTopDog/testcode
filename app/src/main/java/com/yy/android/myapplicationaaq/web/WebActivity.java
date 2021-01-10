
package com.yy.android.myapplicationaaq.web;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityWebBinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class WebActivity extends AppCompatActivity {

    ActivityWebBinding binding;

    Bitmap bitmap;

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            binding.image.setImageBitmap(bitmap);
        }
    }

    MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web);
        binding.webView.loadUrl("http://m.100.com/?source=119");
        String url = "http://edu100.bs2cdn.100" +
                ".com/e51908138d739172ba6692c3f3ccc40eaf65b259.jpg";
        myHandler = new MyHandler();
        binding.test.setOnClickListener(v -> {

            // new Thread(new Runnable() {
            //     @Override
            //     public void run() {
            //         FutureTarget<GlideDrawable> futureTarget =
            //                 Glide.with(WebActivity.this).load(url).into(640,280);
            //     }
            // }).start();

            Glide.with(WebActivity.this)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.image);
            // Glide.with(getContext()).load(path).asBitmap().into(640,280).get();

            // try {
            //     binding.image.setImageDrawable(futureTarget.get());
            // } catch (ExecutionException e) {
            //     e.printStackTrace();
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }

        });
        binding.test2.setOnClickListener(v -> {
            Glide.with(WebActivity.this)
                    .load(url)
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource,
                                                    GlideAnimation<? super Bitmap> glideAnimation) {
                            binding.image.setImageBitmap(resource);
                        }
                    });
        });
    }

    @Override
    protected void onDestroy() {
        binding.webView.loadUrl(null);
        super.onDestroy();
        Log.i("NativeWebView", "onDestroy");
    }
}