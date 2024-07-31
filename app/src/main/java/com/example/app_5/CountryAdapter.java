package com.example.app_5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_5.databinding.ListItemBinding;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private final OnStateClickListener onClickListener;
    private final LayoutInflater inflater;
    private final List<Country> countries;

    CountryAdapter(Context context, List<Country> countries, OnStateClickListener onClickListener) {
        this.onClickListener = onClickListener;
        this.countries = countries;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CountryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = ListItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CountryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Country country = countries.get(position);
        holder.binding.flag.setImageResource(country.getFlagResource());
        holder.binding.name.setText(country.getName());
        holder.binding.capital.setText(country.getCapital());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra("flagResource", country.getFlagResource());
            intent.putExtra("name", country.getName());
            intent.putExtra("capital", country.getCapital());
            v.getContext().startActivity(intent);
            onClickListener.onStateClick(country, position);
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    interface OnStateClickListener {
        void onStateClick(Country country, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding binding;

        ViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
