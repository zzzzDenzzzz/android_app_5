package com.example.app_5;

public class Country {

    private final String name;
    private final String capital;
    private final int flagResource;

    public Country(String name, String capital, int flag) {
        this.name = name;
        this.capital = capital;
        this.flagResource = flag;
    }

    public String getName() {
        return this.name;
    }

    public String getCapital() {
        return this.capital;
    }

    public int getFlagResource() {
        return this.flagResource;
    }
}
