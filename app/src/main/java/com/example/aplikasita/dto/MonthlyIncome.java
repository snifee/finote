package com.example.aplikasita.dto;

public class MonthlyIncome {
    private float incomeTotal;
    private String monthYear;

    public MonthlyIncome(float incomeTotal, String monthYear) {
        this.incomeTotal = incomeTotal;
        this.monthYear = monthYear;
    }

    public float getIncomeTotal() {
        return incomeTotal;
    }

    public void setIncomeTotal(float incomeTotal) {
        this.incomeTotal = incomeTotal;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }
}
