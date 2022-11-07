package com.example.aplikasita.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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

    @ColumnInfo(name = "month")
    private String month;

    @ColumnInfo(name = "keterangan")
    private String keterangan;

//    @ColumnInfo(name = "waktu")
//    private Date waktu;

    public Income(Long id, Integer noRekening, Integer jumlah, String month, String keterangan, Date waktu) {
        this.id = id;
        this.noRekening = noRekening;
        this.jumlah = jumlah;
        this.month = month;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }


}
