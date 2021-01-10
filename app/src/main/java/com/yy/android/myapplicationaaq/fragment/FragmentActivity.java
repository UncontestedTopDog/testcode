package com.yy.android.myapplicationaaq.fragment;

import android.os.Bundle;
import android.util.Log;

import com.yy.android.myapplicationaaq.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class FragmentActivity extends AppCompatActivity {

    private static final String TAG = "BlankFragmentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("onCreate");
        setContentView(R.layout.activity_fragment);
        BlankFragment fragment = new BlankFragment(100);
        BlankFragment fragment2 = new BlankFragment(999);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, fragment, "TEST")
                .commit();

        findViewById(R.id.hide).setOnClickListener(v -> {
            Log.i(TAG, "AAAa");
            FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
            // Fragment fragment1 = getSupportFragmentManager().findFragmentByTag("TEST");
            transaction2.hide(fragment).commit();
        });

        findViewById(R.id.show).setOnClickListener(v -> {
            Log.i(TAG, "BBBb");
            FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
            // Fragment fragment1 = getSupportFragmentManager().findFragmentByTag("TEST");
            // transaction3.show(fragment).commit();
            transaction3.replace(R.id.fragment_container,fragment2).commit();
        });

    }

    @Deprecated
    public void test() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    private void log(String msg) {
        Log.i(TAG, msg);
    }
}