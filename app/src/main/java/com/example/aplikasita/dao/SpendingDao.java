package com.example.aplikasita.dao;


import androidx.room.Dao;
import androidx.room.Query;

import com.example.aplikasita.model.Spending;

import java.util.List;

@Dao
public interface SpendingDao {

    @Query("SELECT * FROM spending_table")
    List<Spending> getAllSpending();

    @Query("SELECT * FROM spending_table WHERE month LIKE :rqmonth")
    List<Spending> getSpendingByMonth(String rqmonth);
}
