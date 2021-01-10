package com.yy.android.myapplicationaaq.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;

import android.os.Bundle;

import com.yy.android.myapplicationaaq.R;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        findViewById(R.id.init).setOnClickListener(v->{
            Manager.init();
        });

        findViewById(R.id.get).setOnClickListener(v->{
            Manager.get().subscribe(new Observer<String>() {
                @Override
                public void onCompleted() {
                    System.out.println("AAAAAAAA   ");
                }

                @Override
                public void onError(Throwable e) {
                    System.out.println("AAAAAAAA   "+e.toString());
                }

                @Override
                public void onNext(String s) {
                    System.out.println("AAAAAAAA   "+s);
                }
            });
        });

        findViewById(R.id.get2).setOnClickListener(v->{
            Manager.get2().enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    System.out.println("AAAAAAA"+response.body().toString());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    System.out.println("AAAAAAA!!!!"+t.toString());
                }
            });
        });
    }
}