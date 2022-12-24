package com.example.aplikasita.dto;

public class MonthlyIncome {
    private float incomeTotal;
    private String dateYear;

    public MonthlyIncome(float spendingTotal, float incomeTotal, String dateYear) {
        this.incomeTotal = incomeTotal;
        this.dateYear = dateYear;
    }

    public float getIncomeTotal() {
        return incomeTotal;
    }

    public void setIncomeTotal(float incomeTotal) {
        this.incomeTotal = incomeTotal;
    }

    public String getDateYear() {
        return dateYear;
    }

    public void setDateYear(String dateYear) {
        this.dateYear = dateYear;
    }
}
