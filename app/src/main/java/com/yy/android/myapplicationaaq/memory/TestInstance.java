package com.yy.android.myapplicationaaq.memory;

import android.app.Activity;

public class TestInstance {

    private static volatile TestInstance instance;

    private Activity activity;

    public static TestInstance getInstance() {
        if (instance == null) {
            synchronized (TestInstance.class) {
                if (instance == null) {
                    instance = new TestInstance();
                }
            }
        }
        return instance;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
