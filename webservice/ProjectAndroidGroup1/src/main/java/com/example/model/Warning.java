package com.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "warning")
public class Warning {

	@XmlElement(name = "warning_Id")
	private int warning_Id;

	@XmlElement(name = "warning_lat")
	private double warning_lat;

	@XmlElement(name = "warning_lng")
	private double warning_lng;

	@XmlElement(name = "warning_address")
	private String warning_address;

	@XmlElement(name = "warning_category")
	private int warning_category;

	@XmlElement(name = "warning_name")
	private String warning_name;

	@XmlElement(name = "create_time")
	private String create_time;

	public Warning() {

	}

	public Warning(int warning_Id, double warning_lat, double warning_lng, String warning_address, int warning_category,
			String warning_name, String create_time) {
		super();
		this.warning_Id = warning_Id;
		this.warning_lat = warning_lat;
		this.warning_lng = warning_lng;
		this.warning_address = warning_address;
		this.warning_category = warning_category;
		this.warning_name = warning_name;
		this.create_time = create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public int getWarning_Id() {
		return warning_Id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public String getWarning_name() {
		return warning_name;
	}

	public double getWarning_lat() {
		return warning_lat;
	}

	public double getWarning_lng() {
		return warning_lng;
	}

	public String getWarning_address() {
		return warning_address;
	}

	public int getWarning_category() {
		return warning_category;
	}

}
