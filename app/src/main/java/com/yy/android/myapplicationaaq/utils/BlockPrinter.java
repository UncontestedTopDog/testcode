package com.yy.android.myapplicationaaq.utils;

import android.os.Looper;
import android.util.Log;
import android.util.Printer;

import com.yy.android.myapplicationaaq.utils.sampler.BlockCpuSampler;
import com.yy.android.myapplicationaaq.utils.sampler.BlockStackSampler;

import java.util.ArrayList;

import static com.yy.android.myapplicationaaq.utils.BlockConstants.DEFAULT_MAX_ENTRY_COUNT;

public class BlockPrinter implements Printer {

    private static final String TAG = "BlockPrinterLog";
    boolean start = true;
    long startTime = 0;
    private long blockTime = 5000;
    BlockStackSampler stackSampler;
    private long last = 0;
    // BlockCpuSampler cpuSampler;

    public BlockPrinter() {
        stackSampler = new BlockStackSampler(Looper.getMainLooper().getThread(),
                DEFAULT_MAX_ENTRY_COUNT,1000);
        // cpuSampler = new BlockCpuSampler(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Log.i(TAG, "block test: ");
                    if (startTime != 0 && last != startTime){
                        long endTime = 0;
                        endTime = System.currentTimeMillis();
                        if (isBlock(endTime)) {
                            last = startTime;
                            Log.i(TAG, "block time: " + (endTime - startTime));
                            ArrayList<String> lists =  stackSampler.getThreadStackEntries(startTime,endTime);
                            for (String s : lists) {
                                Log.i(TAG, s);
                            }
                            // Log.i(TAG,cpuSampler.getCpuRateInfo());
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void println(String x) {
        if (start) {
            start = false;
            startTime = System.currentTimeMillis();
            stackSampler.start();
            // cpuSampler.start();
        } else {
            long endTime = 0;
            endTime = System.currentTimeMillis();
            start = true;
            stackSampler.stop();
            // cpuSampler.stop();
            if (isBlock(endTime)) {
                Log.i(TAG, "block time: " + (endTime - startTime));
                Log.i(TAG, x);
                ArrayList<String> lists =  stackSampler.getThreadStackEntries(startTime,endTime);
                for (String s : lists) {
                    Log.i(TAG, s);
                }
                // Log.i(TAG,cpuSampler.getCpuRateInfo());
            }
            startTime = 0;
        }
    }

    private boolean isBlock(long endTime) {
        return endTime - startTime > blockTime;
    }
}
