package com.example.aplikasita.model;

public class Bank {
    private String bankName;
    private String saldo;
    private String rekeneing;

    public Bank(String bankName, String saldo, String rekeneing) {
        this.bankName = bankName;
        this.saldo = saldo;
        this.rekeneing = rekeneing;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getRekeneing() {
        return rekeneing;
    }

    public void setRekeneing(String rekeneing) {
        this.rekeneing = rekeneing;
    }
}
