package com.example.model;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "objectLocationGas")
public class ObjectLocationGas {
	@XmlElement(name = "mLat")
	private double mLat;

	@XmlElement(name = "mLng")
	private double mLng;

	@XmlElement(name = "title")
	private String title;

	@XmlElement(name = "snippet")
	private String snippet;

	
	public ObjectLocationGas() {

	}
	
	public ObjectLocationGas(double mLat, double mLng, String title, String snippet) {
		super();
		this.mLat = mLat;
		this.mLng = mLng;
		this.title = title;
		this.snippet = snippet;
	}

	public double getmLat() {
		return mLat;
	}

	public double getmLng() {
		return mLng;
	}

	public String getTitle() {
		return title;
	}

	public String getSnippet() {
		return snippet;
	}

}
