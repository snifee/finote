package com.example.aplikasita.data.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aplikasita.data.entity.Budget;

import java.util.List;

@Dao
public interface BudgetDao {

    @Insert
    void insert(Budget budget);

    @Update
    void update(Budget budget);

    @Delete
    void delete(Budget budget);

    @Query("SELECT * FROM budget_table")
    LiveData<List<Budget>> getAllBudget();

    @Query("SELECT SUM(jumlah) AS jumlah FROM budget_table")
    LiveData<Long> getTotalBudget();
}
