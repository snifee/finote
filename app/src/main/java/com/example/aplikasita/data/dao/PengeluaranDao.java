package com.example.aplikasita.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aplikasita.data.entity.Pengeluaran;
import com.example.aplikasita.dto.TotalSpendingByKategori;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Dao
public interface PengeluaranDao {

    @Insert
    void insert(Pengeluaran pengeluaran);

    @Update
    void update(Pengeluaran pengeluaran);

    @Delete
    void delete(Pengeluaran pengeluaran);

    @Query("DELETE FROM tabel_pengeluaran")
    void deleteAllSpending();

    @Query("SELECT * FROM tabel_pengeluaran")
    LiveData<List<Pengeluaran>> getAllSpending();

    @Query("SELECT * FROM tabel_pengeluaran WHERE strftime('%m-%Y', waktu / 1000, 'unixepoch') LIKE :rqbulanTahun")
    LiveData<List<Pengeluaran>> getAllSpendingByMonth(String rqbulanTahun);

    @Query("SELECT SUM(jumlah) FROM tabel_pengeluaran WHERE strftime('%m-%Y', waktu / 1000, 'unixepoch') LIKE :rqbulanTahun")
    LiveData<Long> getSumSpendingByMonth(String rqbulanTahun);

    @Query("SELECT SUM(jumlah) AS total, idKategoriPengeluaran AS kategori FROM  tabel_pengeluaran WHERE strftime('%m-%Y', waktu / 1000, 'unixepoch') LIKE :rqbulanTahun GROUP BY idKategoriPengeluaran")
    LiveData<List<TotalSpendingByKategori>> totalSpendingByKategori(String rqbulanTahun);

}
