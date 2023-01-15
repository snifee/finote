package com.example.aplikasita.dto;


public class Month {
    private String month;
    private String income;
    private String outcome;

    public Month(String month, String income, String outcome) {
        this.month = month;
        this.income = income;
        this.outcome = outcome;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
