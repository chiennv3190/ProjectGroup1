package com.example.chien.projectgroup1.model;

/**
 * Created by chien on 8/15/2016.
 */
public class Warning {
    private int id;
    private double mLatWarning;
    private double mLngWarning;
    private String addressWarning;
    private String categoryWarning;
    private int category_Id;
    private String create_time;

    public Warning() {
    }

    public Warning(double mLatWarning, double mLngWarning, String addressWarning, int category_Id, String create_time) {
        this.mLatWarning = mLatWarning;
        this.mLngWarning = mLngWarning;
        this.addressWarning = addressWarning;
        this.category_Id = category_Id;
        this.create_time = create_time;
    }

    public Warning(int id, double mLatWarning,  double mLngWarning, String addressWarning, String categoryWarning, int category_Id, String create_time) {
        this.id = id;
        this.mLatWarning = mLatWarning;
        this.mLngWarning = mLngWarning;
        this.addressWarning = addressWarning;
        this.categoryWarning = categoryWarning;
        this.category_Id = category_Id;
        this.create_time = create_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(int category_Id) {
        this.category_Id = category_Id;
    }

    public double getmLatWarning() {
        return mLatWarning;
    }

    public void setmLatWarning(double mLatWarning) {
        this.mLatWarning = mLatWarning;
    }

    public double getmLngWarning() {
        return mLngWarning;
    }

    public void setmLngWarning(double mLngWarning) {
        this.mLngWarning = mLngWarning;
    }

    public String getAddressWarning() {
        return addressWarning;
    }

    public void setAddressWarning(String addressWarning) {
        this.addressWarning = addressWarning;
    }

    public String getCategoryWarning() {
        return categoryWarning;
    }

    public void setCategoryWarning(String categoryWarning) {
        this.categoryWarning = categoryWarning;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCreate_time() {
        return create_time;
    }
}
