package com.example.chien.projectgroup1.model;

/**
 * Created by chien on 8/14/2016.
 */
public class LocationCoffee {
    private double mLat;
    private double mLng;
    private String title;
    private String snippet;

    public LocationCoffee() {
    }

    public LocationCoffee(double mLat, double mLng, String title, String snippet) {
        this.mLat = mLat;
        this.mLng = mLng;
        this.title = title;
        this.snippet = snippet;
    }

    public double getmLat() {
        return mLat;
    }

    public void setmLat(double mLat) {
        this.mLat = mLat;
    }

    public double getmLng() {
        return mLng;
    }

    public void setmLng(double mLng) {
        this.mLng = mLng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}
