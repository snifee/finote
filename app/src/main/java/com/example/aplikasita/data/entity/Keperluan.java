package com.example.aplikasita.data.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabel_keperluan")
public class Keperluan {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "kebutuhan")
    private String kebutuhan;

    @ColumnInfo(name = "katagori_kebutuhan")
    private String kategoriKebutuhan;

    @ColumnInfo(name = "jumlah")
    private Long jumlah;

    public Keperluan(String kebutuhan, String kategoriKebutuhan, Long jumlah) {
        this.kebutuhan = kebutuhan;
        this.kategoriKebutuhan = kategoriKebutuhan;
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

    public String getKategoriKebutuhan() {
        return kategoriKebutuhan;
    }

    public void setKategoriKebutuhan(String kategoriKebutuhan) {
        this.kategoriKebutuhan = kategoriKebutuhan;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }
}
