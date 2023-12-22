package com.doctor3.propertytest;

import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.doctor3.propertytest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("maclib");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView tv = binding.sampleText;

        String a  = getmac();
        if (a.length() != 0 && Build.VERSION.SDK_INT>= 30){
            tv.setText("Magisk is found");
        } else if (Build.VERSION.SDK_INT < 30) {
            tv.setText("Unsupported");
        } else {
            tv.setText("Normal");
        }

    }

    public static native String getmac();
}