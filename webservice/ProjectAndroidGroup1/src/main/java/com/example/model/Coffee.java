package com.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coffee")
public class Coffee {

	@XmlElement(name = "mLatCoffee")
	private double mLatCoffee;

	@XmlElement(name = "mLngCoffee")
	private double mLngCoffee;

	@XmlElement(name = "titleCoffee")
	private String titleCoffee;

	@XmlElement(name = "snippetCoffee")
	private String snippetCoffee;

	public Coffee(double mLatCoffee, double mLngCoffee, String titleCoffee, String snippetCoffee) {
		super();
		this.mLatCoffee = mLatCoffee;
		this.mLngCoffee = mLngCoffee;
		this.titleCoffee = titleCoffee;
		this.snippetCoffee = snippetCoffee;
	}

	public Coffee() {
		
	}

	public double getmLatCoffee() {
		return mLatCoffee;
	}

	public double getmLngCoffee() {
		return mLngCoffee;
	}

	public String getTitleCoffee() {
		return titleCoffee;
	}

	public String getSnippetCoffee() {
		return snippetCoffee;
	}
	
	
}
