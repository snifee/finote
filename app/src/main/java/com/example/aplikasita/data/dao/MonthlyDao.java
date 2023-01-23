package com.example.aplikasita.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.aplikasita.dto.MonthlyCashFlow;
import com.example.aplikasita.dto.MonthlyIncome;
import com.example.aplikasita.dto.MonthlySpending;

import java.util.List;


@Dao
public interface MonthlyDao {


    @Query("SELECT SUM(jumlah) AS spendingTotal, strftime('%m-%Y', waktu / 1000, 'unixepoch') AS monthYear FROM tabel_pengeluaran GROUP BY strftime('%m-%Y', waktu / 1000, 'unixepoch')")
    LiveData<List<MonthlySpending>> getMonthlySpending();


    @Query("SELECT SUM(jumlah) AS incomeTotal, strftime('%m-%Y', waktu / 1000, 'unixepoch') AS monthYear FROM tabel_pendapatan GROUP BY strftime('%m-%Y', waktu / 1000, 'unixepoch')")
    LiveData<List<MonthlyIncome>> getMonthlyIncome();

}
