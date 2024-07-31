package com.example.app_5;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_5.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setInitialData();
        CountryAdapter.OnStateClickListener stateClickListener = (country, position) -> {
        };
        CountryAdapter adapter = new CountryAdapter(this, countries, stateClickListener);
        binding.list.setAdapter(adapter);
    }

    private void setInitialData() {
        countries.addAll(Arrays.asList(
                new Country("Бразилия", "Бразилиа", R.drawable.brazilia),
                new Country("Аргентина", "Буэнос-Айрес", R.drawable.argentina),
                new Country("Колумбия", "Богота", R.drawable.columbia),
                new Country("Уругвай", "Монтевидео", R.drawable.urugvai),
                new Country("Чили", "Сантьяго", R.drawable.chile),
                new Country("США", "Вашингтон", R.drawable.usa),
                new Country("Россия", "Москва", R.drawable.russia)));
    }
}