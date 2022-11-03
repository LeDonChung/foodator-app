package com.dmt.ledonchung.foodatorapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dmt.ledonchung.foodatorapp.R;
import com.dmt.ledonchung.foodatorapp.databinding.ActivityIntroBinding;

public class IntroActivity extends AppCompatActivity {
    private ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}