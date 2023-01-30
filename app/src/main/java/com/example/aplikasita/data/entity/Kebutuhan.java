package com.example.aplikasita.data.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabel_anggaran_kebutuhan")
public class Kebutuhan {
    @PrimaryKey(autoGenerate = true)
    private Integer idKebutuhan;

    @ColumnInfo(name = "kebutuhan")
    private String kebutuhan;

    @ColumnInfo(name = "id_katagori_pengeluaran")
    private Integer idKategoriPengeluaran;

    @ColumnInfo(name = "jumlah")
    private Long jumlah;

    public Kebutuhan(String kebutuhan, Integer kategoriKebutuhan, Long jumlah) {
        this.kebutuhan = kebutuhan;
        this.idKategoriPengeluaran = kategoriKebutuhan;
        this.jumlah = jumlah;
    }

    public Kebutuhan(){

    }

    public Integer getIdKebutuhan() {
        return idKebutuhan;
    }

    public void setIdKebutuhan(Integer idKebutuhan) {
        this.idKebutuhan = idKebutuhan;
    }

    public String getKebutuhan() {
        return kebutuhan;
    }

    public void setKebutuhan(String kebutuhan) {
        this.kebutuhan = kebutuhan;
    }

    public Integer getIdKategoriPengeluaran() {
        return idKategoriPengeluaran;
    }

    public void setIdKategoriPengeluaran(Integer idKategoriPengeluaran) {
        this.idKategoriPengeluaran = idKategoriPengeluaran;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }
}
