package com.example.aplikasita.dao;


import androidx.room.Dao;
import androidx.room.Query;

import com.example.aplikasita.model.Spending;

import java.util.List;

@Dao
public interface IncomeDao {

    @Query("SELECT * FROM income_table")
    List<Spending> getAllIncome();

    @Query("SELECT * FROM income_table WHERE month LIKE :rqmonth")
    List<Spending> getIncomeByMonth(String rqmonth);
}
