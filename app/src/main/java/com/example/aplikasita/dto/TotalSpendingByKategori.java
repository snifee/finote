package com.example.aplikasita.dto;

public class TotalSpendingByKategori {
    Integer kategori;
    Long total;

    public TotalSpendingByKategori(Integer kategori, Long total) {
        this.kategori = kategori;
        this.total = total;
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
}
