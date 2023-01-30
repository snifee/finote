package com.example.aplikasita.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.aplikasita.data.entity.KategoriPengeluaran;

@Dao
public interface KategoriPengeluaranDao {
    @Insert
    void insert(KategoriPengeluaran kategoriPengeluaran);
}
