package com.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bank")
public class Bank {

	@XmlElement(name = "bankName")
	private String bankName;

	public Bank() {
	}

	public Bank(String bankName) {
		super();
		this.bankName = bankName;
	}

	public String getBankName() {
		return bankName;
	}

}
