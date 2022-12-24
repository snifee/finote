package com.example.aplikasita.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aplikasita.data.entity.Keperluan;

import java.util.List;

@Dao
public interface KeperluanDao {

    @Insert
    void insert(Keperluan keperluan);

    @Update
    void update(Keperluan keperluan);

    @Delete
    void delete(Keperluan keperluan);

    @Query("SELECT * FROM tabel_keperluan")
    LiveData<List<Keperluan>> getAllBudget();

    @Query("SELECT SUM(jumlah) AS jumlah FROM tabel_keperluan")
    LiveData<Long> getTotalBudget();
}
