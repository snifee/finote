package com.example.aplikasita.data.entity;


import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
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


@Entity(tableName = "tabel_pengeluaran",
        foreignKeys = @ForeignKey(entity = Kebutuhan.class,
        parentColumns = "idKebutuhan",
        childColumns = "idKebutuhanPengeluaran",
        onDelete = CASCADE))
public class Pengeluaran {
    @PrimaryKey(autoGenerate = true)
    private Long idPengeluara;

    @ColumnInfo(name = "jumlah")
    private Long jumlah;

    @ColumnInfo(name = "keterangan")
    private String keterangan;

    @ColumnInfo(name = "waktu")
    private Date waktu;

    @ColumnInfo(name = "bulan_tahun")
    private String bulanTahun;

    private Long idKebutuhanPengeluaran;

    public Pengeluaran(){

    }

    public Pengeluaran(Long jumlah, String keterangan, Date waktu, String bulanTahun, Long idKebutuhanPengeluaran) {
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.waktu = waktu;
        this.bulanTahun = bulanTahun;
        this.idKebutuhanPengeluaran = idKebutuhanPengeluaran;
    }

    public Long getIdPengeluara() {
        return idPengeluara;
    }

    public void setIdPengeluara(Long idPengeluara) {
        this.idPengeluara = idPengeluara;
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

    public Long getIdKebutuhanPengeluaran() {
        return idKebutuhanPengeluaran;
    }

    public void setIdKebutuhanPengeluaran(Long idKebutuhanPengeluaran) {
        this.idKebutuhanPengeluaran = idKebutuhanPengeluaran;
    }
}
