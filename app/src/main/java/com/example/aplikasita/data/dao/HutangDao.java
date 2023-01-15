package com.example.aplikasita.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aplikasita.data.entity.Hutang;

import java.util.List;

@Dao
public interface HutangDao {
    @Insert
    void insert(Hutang hutang);

    @Update
    void update(Hutang hutang);

    @Delete
    void delete(Hutang hutang);

    @Query("SELECT * FROM tabel_hutang")
    LiveData<List<Hutang>> getAllHutang();
}
