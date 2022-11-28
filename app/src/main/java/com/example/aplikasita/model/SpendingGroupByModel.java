package com.example.aplikasita.model;

public class SpendingGroupByModel {
    private float jumlah;
    private String dateYear;

    public SpendingGroupByModel(float jumlah, String dateYear) {
        this.jumlah = jumlah;
        this.dateYear = dateYear;
    }

    public float getTotalSpending() {
        return jumlah;
    }

    public void setTotalSpending(float jumlah) {
        this.jumlah = jumlah;
    }

    public String getDateYear() {
        return dateYear;
    }

    public void setDateYear(String dateYear) {
        this.dateYear = dateYear;
    }
}
