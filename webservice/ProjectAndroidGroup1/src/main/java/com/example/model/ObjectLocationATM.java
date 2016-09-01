package com.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "objectLocationATM")
public class ObjectLocationATM {
	@XmlElement(name = "mLatATM")
	private double mLatATM;

	@XmlElement(name = "mLngATM")
	private double mLngATM;

	@XmlElement(name = "titleATM")
	private String titleATM;

	@XmlElement(name = "snippetATM")
	private String snippetATM;

	public ObjectLocationATM() {
	}

	public ObjectLocationATM(String titleATM) {
		super();
		this.titleATM = titleATM;
	}

	public ObjectLocationATM(double mLatATM, double mLngATM, String titleATM, String snippetATM) {
		super();
		this.mLatATM = mLatATM;
		this.mLngATM = mLngATM;
		this.titleATM = titleATM;
		this.snippetATM = snippetATM;
	}

	public String getTitleATM() {
		return titleATM;
	}

	public double getmLatATM() {
		return mLatATM;
	}

	public double getmLngATM() {
		return mLngATM;
	}

	public String getSnippetATM() {
		return snippetATM;
	}

}
