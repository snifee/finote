package com.example.aplikasita.data.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tabel_hutang")
public class Hutang {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    @ColumnInfo(name = "jumlah")
    private Long jumlah;

    @ColumnInfo(name = "jatuh_tempo")
    private Date jatuhTempo;

    @ColumnInfo(name = "keterangan")
    private String keterangan;

    @ColumnInfo(name = "lunas")
    private Boolean isLunas;

    public Hutang(Long jumlah, Date jatuhTempo, String keterangan, Boolean isLunas) {
        this.jumlah = jumlah;
        this.jatuhTempo = jatuhTempo;
        this.keterangan = keterangan;
        this.isLunas = isLunas;
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

    public Date getJatuhTempo() {
        return jatuhTempo;
    }

    public void setJatuhTempo(Date jatuhTempo) {
        this.jatuhTempo = jatuhTempo;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Boolean getLunas() {
        return isLunas;
    }

    public void setLunas(Boolean lunas) {
        isLunas = lunas;
    }
}
