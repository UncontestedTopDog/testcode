package com.yy.android.myapplicationaaq.arouter.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityArouterServiceBinding;

public class ArouterServiceActivity extends AppCompatActivity {

    @Autowired(name = "/testservice/hello")
    HelloService helloService;

    ActivityArouterServiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_arouter_service);
        ARouter.getInstance().inject(this);

        binding.test.setOnClickListener(v->{
            binding.testText2.setText(""+helloService.sayHello("BBB"));
        });

    }
}