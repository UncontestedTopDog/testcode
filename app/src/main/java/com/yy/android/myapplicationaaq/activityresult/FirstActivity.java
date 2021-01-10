package com.yy.android.myapplicationaaq.activityresult;

import android.os.Bundle;

import com.yy.android.myapplicationaaq.R;
import com.yy.android.myapplicationaaq.databinding.ActivityFirstBinding;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class FirstActivity extends AppCompatActivity {

    ActivityFirstBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first);
        // ActivityResultLauncher launcher =
        //         registerForActivityResult(new MyActivityResultContract(SecondActivity.class),
        //                 result -> {
        //                     Toast.makeText(FirstActivity.this, result, Toast.LENGTH_LONG).show();
        //                     binding.text.setText(result);
        //                 });


        // ActivityResultLauncher<Intent> launcher =
        //         registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        //             binding.text.setText(result.getData().getStringExtra("result"));
        //         });


        ActivityResultLauncher<Void> launcher =
                registerForActivityResult(new ActivityResultContracts.TakePicturePreview(),
                        result -> {
                    binding.image.setImageBitmap(result);
                        });


        binding.test.setOnClickListener(v -> {
            launcher.launch(null);
        });
    }
}