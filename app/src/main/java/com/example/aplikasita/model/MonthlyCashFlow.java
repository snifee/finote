package com.example.aplikasita.model;

public class MonthlyCashFlow {
    private float spendingTotal;
    private float incomeTotal;
    private String dateYear;

    public MonthlyCashFlow(float spendingTotal, String dateYear) {
        this.spendingTotal = spendingTotal;
        this.dateYear = dateYear;
    }

    public float getSpendingTotal() {
        return spendingTotal;
    }

    public void setSpendingTotal(float spendingTotal) {
        this.spendingTotal = spendingTotal;
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
