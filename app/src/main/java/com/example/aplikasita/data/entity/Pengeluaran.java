package com.example.aplikasita.data.entity;


import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "tabel_pengeluaran",
        foreignKeys = @ForeignKey(entity = KategoriPengeluaran.class,
        parentColumns = "id",
        childColumns = "idKategoriPengeluaran",
        onDelete = CASCADE))
public class Pengeluaran {
    @PrimaryKey(autoGenerate = true)
    private Long idPengeluaran;

    @ColumnInfo(name = "jumlah")
    private Long jumlah;

    @ColumnInfo(name = "keterangan")
    private String keterangan;

    @ColumnInfo(name = "waktu")
    private Date waktu;

    private Integer idKategoriPengeluaran;

    public Pengeluaran(){

    }

    public Pengeluaran(Long jumlah, String keterangan, Date waktu, Integer idKategoriPengeluaran) {
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.waktu = waktu;
        this.idKategoriPengeluaran = idKategoriPengeluaran;
    }

    public Long getIdPengeluaran() {
        return idPengeluaran;
    }

    public void setIdPengeluaran(Long idPengeluaran) {
        this.idPengeluaran = idPengeluaran;
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

    public Integer getIdKategoriPengeluaran() {
        return idKategoriPengeluaran;
    }

    public void setIdKategoriPengeluaran(Integer idKategoriPengeluaran) {
        this.idKategoriPengeluaran = idKategoriPengeluaran;
    }
}
