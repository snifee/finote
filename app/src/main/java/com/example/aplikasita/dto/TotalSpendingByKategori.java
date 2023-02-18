package com.example.aplikasita.dto;

public class TotalSpendingByKategori {
    Integer kategori;
    Long total;

    String monthYear;

    public TotalSpendingByKategori(Integer kategori, Long total, String monthYear) {
        this.kategori = kategori;
        this.total = total;
        this.monthYear = monthYear;
    }

    public Integer getKategori() {
        return kategori;
    }

    public void setKategori(Integer kategori) {
        this.kategori = kategori;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }
}
