package com.example.aplikasita.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aplikasita.data.entity.Pendapatan;

import java.util.List;

@Dao
public interface PendapatanDao {

    @Insert
    void insert(Pendapatan pendapatan);

    @Update
    void update(Pendapatan pendapatan);

    @Delete
    void delete(Pendapatan pendapatan);

    @Query("DELETE FROM tabel_pendapatan")
    void deleteAllIncome();

    @Query("SELECT * FROM tabel_pendapatan")
    LiveData<List<Pendapatan>> getAllIncome();

    @Query("SELECT * FROM tabel_pendapatan WHERE strftime('%m-%Y', waktu / 1000, 'unixepoch') LIKE :bulanTahun")
    LiveData<List<Pendapatan>> getIncomeByYearMonth(String bulanTahun);

    @Query("SELECT SUM(jumlah) FROM tabel_pendapatan WHERE strftime('%m-%Y', waktu / 1000, 'unixepoch') LIKE :rqbulanTahun")
    LiveData<Long> getSumIncomeByMonth(String rqbulanTahun);
}
