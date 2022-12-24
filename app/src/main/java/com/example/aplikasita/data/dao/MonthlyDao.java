package com.example.aplikasita.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.aplikasita.dto.MonthlySpending;

import java.util.List;


@Dao
public interface MonthlyDao {


    @Query("SELECT SUM(jumlah) AS spendingTotal, bulan_tahun AS monthYear FROM tabel_pengeluaran GROUP BY bulan_tahun")
    LiveData<List<MonthlySpending>> getMonthlySpending();

}
