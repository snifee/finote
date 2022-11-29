package com.example.aplikasita.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aplikasita.data.entity.Spending;
import com.example.aplikasita.model.MonthlyCashFlow;

import java.util.List;

@Dao
public interface SpendingDao {

    @Insert
    void insert(Spending spending);

    @Update
    void update(Spending spending);

    @Delete
    void delete(Spending spending);

    @Query("DELETE FROM spending_table")
    void deleteAllSpending();

    @Query("SELECT * FROM spending_table")
    LiveData<List<Spending>> getAllSpending();

    @Query("SELECT * FROM spending_table WHERE bulan_tahun LIKE :rqbulanTahun")
    LiveData<List<Spending>> getAllSpendingByMonth(String rqbulanTahun);


}
