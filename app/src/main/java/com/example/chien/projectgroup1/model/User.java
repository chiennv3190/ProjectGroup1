package com.example.chien.projectgroup1.model;

/**
 * Created by chien on 8/18/2016.
 */
public class User {
    private String device_ui_id;
    private Double user_lat;
    private Double user_lng;
    private String token;

    public User() {
    }

    public User(String device_ui_id, Double user_lat, Double user_lng, String token) {
        this.device_ui_id = device_ui_id;
        this.user_lat = user_lat;
        this.user_lng = user_lng;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDevice_ui_id() {
        return device_ui_id;
    }

    public void setDevice_ui_id(String device_ui_id) {
        this.device_ui_id = device_ui_id;
    }

    public Double getUser_lat() {
        return user_lat;
    }

    public void setUser_lat(Double user_lat) {
        this.user_lat = user_lat;
    }

    public Double getUser_lng() {
        return user_lng;
    }

    public void setUser_lng(Double user_lng) {
        this.user_lng = user_lng;
    }
}
