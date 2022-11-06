package com.example.aplikasita.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

//CREATE TABLE IF NOT EXISTS pengeluaran
// (id INTEGER PRIMARY KEY AUTOINCREMENT,
// sumber_pengeluaran INTEGER,
// jumlah INTEGER,
// keterangan TEXT,
// waktu DATETIME,
// jenis_pengeluaran TEXT,
// created_at TEXT DEFAULT CURRENT_TIMESTAMP);


@Entity(tableName = "spending_table")
public class Spending {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "sumber_pengluaran")
    private Integer sumberPengeluaran;

    @ColumnInfo(name = "jumlah")
    private Integer jumlah;

    @ColumnInfo(name = "keterangan")
    private String keterangan;

//    @ColumnInfo(name = "waktu")
//    private Date waktu;

    @ColumnInfo(name = "month")
    private String month;

    @ColumnInfo(name = "jenis_pengeluaran")
    private String jenisPengeluaran;

    public Spending(Long id, Integer sumberPengeluaran, Integer jumlah, String keterangan, Date waktu, String month, String jenisPengeluaran) {
        this.id = id;
        this.sumberPengeluaran = sumberPengeluaran;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.month = month;
        this.jenisPengeluaran = jenisPengeluaran;
    }

    public Spending(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSumberPengeluaran() {
        return sumberPengeluaran;
    }

    public void setSumberPengeluaran(Integer sumberPengeluaran) {
        this.sumberPengeluaran = sumberPengeluaran;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getJenisPengeluaran() {
        return jenisPengeluaran;
    }

    public void setJenisPengeluaran(String jenisPengeluaran) {
        this.jenisPengeluaran = jenisPengeluaran;
    }
}
