package com.example.aplikasita.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy;

import com.example.aplikasita.data.entity.Income;
import com.example.aplikasita.data.entity.Spending;

import java.util.List;

@Dao
public interface IncomeDao {

    @Query("SELECT * FROM income_table")
    LiveData<List<Income>> getAllIncome();

    @Query("SELECT * FROM income_table WHERE month LIKE :rqmonth")
    LiveData<List<Income>> getIncomeByMonth(String rqmonth);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertIncome(Income income);
}
