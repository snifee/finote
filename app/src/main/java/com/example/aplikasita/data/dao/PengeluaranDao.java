package com.example.aplikasita.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aplikasita.data.entity.Pengeluaran;

import java.util.List;

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

}
