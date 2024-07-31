package com.example.app_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_5.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        int flagResource = intent.getIntExtra("flagResource", 0);
        String name = intent.getStringExtra("name");
        String capital = intent.getStringExtra("capital");

        binding.flagImageView.setImageResource(flagResource);
        binding.nameTextView.setText(name);
        binding.capitalTextView.setText(capital);
    }
}