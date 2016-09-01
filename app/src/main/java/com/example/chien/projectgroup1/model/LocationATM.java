package com.example.chien.projectgroup1.model;

/**
 * Created by chien on 7/25/2016.
 */
public class LocationATM {
    private double mLatATM;
    private double mLngATM;
    private String titleATM;
    private String snippetATM;

    public LocationATM() {
    }

    public LocationATM(double mLatATM, double mLngATM, String titleATM, String snippetATM) {
        this.mLatATM = mLatATM;
        this.mLngATM = mLngATM;
        this.titleATM = titleATM;
        this.snippetATM = snippetATM;
    }

    public double getmLatATM() {
        return mLatATM;
    }

    public void setmLatATM(double mLatATM) {
        this.mLatATM = mLatATM;
    }

    public double getmLngATM() {
        return mLngATM;
    }

    public void setmLngATM(double mLngATM) {
        this.mLngATM = mLngATM;
    }

    public String getTitleATM() {
        return titleATM;
    }

    public void setTitleATM(String titleATM) {
        this.titleATM = titleATM;
    }

    public String getSnippetATM() {
        return snippetATM;
    }

    public void setSnippetATM(String snippetATM) {
        this.snippetATM = snippetATM;
    }
}
