package com.yy.android.myapplicationaaq.touch;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.yy.android.myapplicationaaq.R;

import androidx.appcompat.app.AppCompatActivity;

public class TouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        // Handler handler = new Handler();
        // handler.postDelayed(new Runnable() {
        //     @Override
        //     public void run() {
        //         findViewById(R.id.blue).setVisibility(View.VISIBLE);
        //     }
        // },1000*3);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("TouchTest",
                "TouchActivity onTouchEvent " + MotionEvent.actionToString(event.getAction()));
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("TouchTest",
                "TouchActivity dispatchTouchEvent " + MotionEvent.actionToString(ev.getAction()));
        // if (ev.getAction()==MotionEvent.ACTION_MOVE)
        //     return true;
        return super.dispatchTouchEvent(ev);
    }

}