package com.example.chien.projectgroup1.model;

/**
 * Created by chien on 7/25/2016.
 */
public class Bank {
    private String bankName;
    private String imgvBank;

    public Bank() {
    }

    public Bank(String bankName) {

        this.bankName = bankName;
    }

    public String getImgvBank() {
        return imgvBank;
    }

    public void setImgvBank(String imgvBank) {
        this.imgvBank = imgvBank;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
