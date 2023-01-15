package com.example.aplikasita.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aplikasita.data.entity.Kebutuhan;

import java.util.List;

@Dao
public interface KebutuhanDao {

    @Insert
    void insert(Kebutuhan kebutuhan);

    @Update
    void update(Kebutuhan kebutuhan);

    @Delete
    void delete(Kebutuhan kebutuhan);

    @Query("SELECT * FROM tabel_keperluan")
    LiveData<List<Kebutuhan>> getAllBudget();

    @Query("SELECT SUM(jumlah) AS jumlah FROM tabel_keperluan")
    LiveData<Long> getTotalBudget();
}
