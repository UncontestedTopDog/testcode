package com.yy.android.myapplicationaaq.leakcanary;

import java.util.ArrayList;
import java.util.List;

public class TestLeak {

    private static volatile TestLeak instance;

    public static TestLeak getInstance() {
        if (instance == null) {
            synchronized (TestLeak.class) {
                if (instance == null) {
                    instance = new TestLeak();
                }
            }
        }
        return instance;
    }

    private List<VeryBig> veryBigs = new ArrayList<>();
    private VeryBig vb;

    public void add(VeryBig vb) {
        veryBigs.add(vb);
    }

    public void clear() {
        veryBigs.clear();
    }

    public void setVb(VeryBig vb) {
        this.vb = vb;
    }
}
