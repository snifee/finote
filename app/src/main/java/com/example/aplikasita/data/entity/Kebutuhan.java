package com.example.aplikasita.data.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabel_keperluan")
public class Kebutuhan {
    @PrimaryKey(autoGenerate = true)
    private Long idKebutuhan;

    @ColumnInfo(name = "kebutuhan")
    private String kebutuhan;

    @ColumnInfo(name = "katagori_kebutuhan")
    private String kategoriKebutuhan;

    @ColumnInfo(name = "jumlah")
    private Long jumlah;

    public Kebutuhan(String kebutuhan, String kategoriKebutuhan, Long jumlah) {
        this.kebutuhan = kebutuhan;
        this.kategoriKebutuhan = kategoriKebutuhan;
        this.jumlah = jumlah;
    }

    public Long getIdKebutuhan() {
        return idKebutuhan;
    }

    public void setIdKebutuhan(Long idKebutuhan) {
        this.idKebutuhan = idKebutuhan;
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
