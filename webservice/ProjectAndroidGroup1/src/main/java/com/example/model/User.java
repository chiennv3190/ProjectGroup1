package com.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {
	@XmlElement(name = "user_device_ui_id")
	private String user_device_ui_id;
	
	@XmlElement(name = "user_lat")
	private double user_lat;
	
	@XmlElement(name = "user_lng")
	private double user_lng;
	
	@XmlElement(name = "token")
	private String token;

	public User() {
		
	}

	public User(String user_device_ui_id, double user_lat, double user_lng) {
		super();
		this.user_device_ui_id = user_device_ui_id;
		this.user_lat = user_lat;
		this.user_lng = user_lng;
	}
	

	public User(String user_device_ui_id, double user_lat, double user_lng, String token) {
		super();
		this.user_device_ui_id = user_device_ui_id;
		this.user_lat = user_lat;
		this.user_lng = user_lng;
		this.token = token;
	}

	
	public String getToken() {
		return token;
	}

	public String getUser_device_ui_id() {
		return user_device_ui_id;
	}

	public double getUser_lat() {
		return user_lat;
	}

	public double getUser_lng() {
		return user_lng;
	}
	
	
}
