package com.example.aplikasita.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "kategori_kebutuhan")
public class KategoriPengeluaran {
    @PrimaryKey(autoGenerate = false)
    private Integer id;

    @ColumnInfo(name = "nama")
    private String nama;

    public KategoriPengeluaran(){

    }

    public KategoriPengeluaran(Integer id,String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
