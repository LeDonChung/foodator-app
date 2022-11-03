package com.dmt.ledonchung.foodatorapp.activities;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.dmt.ledonchung.foodatorapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}