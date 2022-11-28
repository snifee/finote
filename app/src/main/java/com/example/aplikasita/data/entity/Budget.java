package com.example.aplikasita.data.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "budget_table")
public class Budget {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "kebutuhan")
    private String kebutuhan;

    @ColumnInfo(name = "category_kebutuhan")
    private String categoryKebutuhan;

    @ColumnInfo(name = "jumlah")
    private Long jumlah;

    public Budget(String kebutuhan, String categoryKebutuhan, Long jumlah) {
        this.kebutuhan = kebutuhan;
        this.categoryKebutuhan = categoryKebutuhan;
        this.jumlah = jumlah;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKebutuhan() {
        return kebutuhan;
    }

    public void setKebutuhan(String kebutuhan) {
        this.kebutuhan = kebutuhan;
    }

    public String getCategoryKebutuhan() {
        return categoryKebutuhan;
    }

    public void setCategoryKebutuhan(String categoryKebutuhan) {
        this.categoryKebutuhan = categoryKebutuhan;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }
}
