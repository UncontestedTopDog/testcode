package com.yy.android.myapplicationaaq.databinding;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataBean3 extends ViewModel {
    public MutableLiveData<String> userName = new MutableLiveData<>();
    public MutableLiveData<String> userPwd  = new MutableLiveData<>();

    @Override
    public String toString() {
        return "DataBean1{" +
                "userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
