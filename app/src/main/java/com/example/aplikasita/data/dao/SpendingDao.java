package com.example.aplikasita.data.dao;


import androidx.room.Dao;
import androidx.room.Query;

import com.example.aplikasita.data.entity.Spending;

import java.util.List;

@Dao
public interface SpendingDao {

    @Query("SELECT * FROM spending_table")
    List<Spending> getAllSpending();

}
