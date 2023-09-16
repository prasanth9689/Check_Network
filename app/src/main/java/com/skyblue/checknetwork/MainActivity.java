package com.skyblue.checknetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.skyblue.checknetwork.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        CheckNetwork network = new CheckNetwork(getApplicationContext());
        network.registerNetworkCallback();

        binding.check.setOnClickListener(view1 -> {
            // Check network connection
            if (GlobalVariables.isNetworkConnected){
                // Internet Connected
                binding.status.setText("Connected");
                binding.status.setTextColor(Color.GREEN);
            }else{
                // Not Connected
                binding.status.setText("Check Internet connection!");
                binding.status.setTextColor(Color.RED);
            }
        });
    }
}