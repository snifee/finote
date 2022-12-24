package com.example.aplikasita.dto;

public class MonthlySpending {
    private float spendingTotal;
    private String monthYear;

    public MonthlySpending(float spendingTotal, String monthYear) {
        this.spendingTotal = spendingTotal;
        this.monthYear = monthYear;
    }

    public float getSpendingTotal() {
        return spendingTotal;
    }

    public void setSpendingTotal(float spendingTotal) {
        this.spendingTotal = spendingTotal;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }
}
