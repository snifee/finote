package com.example.aplikasita.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.Date;

//CREATE TABLE IF NOT EXISTS pemasukan (
// id INTEGER PRIMARY KEY AUTOINCREMENT,
// no_rekening INTEGER,
// jumlah INTEGER,
// bulan TEXT,
// created_at TEXT DEFAULT CURRENT_TIMESTAMP);


@Entity(tableName = "income_table")
public class Income {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "no_rekening")
    private Integer noRekening;

    @ColumnInfo(name = "jumlah")
    private Integer jumlah;

    @ColumnInfo(name = "waktu")
    private Date waktu;

    @ColumnInfo(name = "keterangan")
    private String keterangan;

    public Income(Integer noRekening, Integer jumlah, Date waktu, String keterangan) {
        this.noRekening = noRekening;
        this.jumlah = jumlah;
        this.waktu = waktu;
        this.keterangan = keterangan;
    }

    public Income(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(Integer noRekening) {
        this.noRekening = noRekening;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
