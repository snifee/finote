package com.example.aplikasita.data.entity;


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


@Entity(tableName = "tabel_pengeluaran")
public class Pengeluaran {
    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "jumlah")
    private Long jumlah;

    @ColumnInfo(name = "keterangan")
    private String keterangan;

    @ColumnInfo(name = "waktu")
    private Date waktu;

    @ColumnInfo(name = "bulan_tahun")
    private String bulanTahun;

    @ColumnInfo(name = "jenis_pengeluaran")
    private String jenisPengeluaran;

    public Pengeluaran(){

    }

    public Pengeluaran(Long jumlah, String keterangan, Date waktu, String bulanTahun, String jenisPengeluaran) {
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.waktu = waktu;
        this.bulanTahun = bulanTahun;
        this.jenisPengeluaran = jenisPengeluaran;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
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

    public String getBulanTahun() {
        return bulanTahun;
    }

    public void setBulanTahun(String bulanTahun) {
        this.bulanTahun = bulanTahun;
    }

    public String getJenisPengeluaran() {
        return jenisPengeluaran;
    }

    public void setJenisPengeluaran(String jenisPengeluaran) {
        this.jenisPengeluaran = jenisPengeluaran;
    }
}
