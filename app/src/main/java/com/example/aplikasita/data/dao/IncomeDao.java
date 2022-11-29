package com.example.aplikasita.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import com.example.aplikasita.data.entity.Income;
import com.example.aplikasita.data.entity.Spending;

import java.util.List;

@Dao
public interface IncomeDao {

    @Insert
    void insert(Income income);

    @Update
    void update(Income income);

    @Delete
    void delete(Income income);

    @Query("DELETE FROM income_table")
    void deleteAllIncome();

    @Query("SELECT * FROM income_table")
    LiveData<List<Income>> getAllIncome();

    @Query("SELECT * FROM income_table WHERE bulan_tahun=:bulanTahun")
    LiveData<List<Income>> getIncomeByYearMonth(String bulanTahun);
}
