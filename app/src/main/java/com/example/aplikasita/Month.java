package com.example.aplikasita;

public class Month {
    private String month;
    private double income;
    private double outcome;

    public Month(String month, double income, double outcome) {
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

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getOutcome() {
        return outcome;
    }

    public void setOutcome(double outcome) {
        this.outcome = outcome;
    }
}
