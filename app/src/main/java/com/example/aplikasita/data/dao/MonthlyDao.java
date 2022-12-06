package com.example.aplikasita.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.aplikasita.model.MonthlyCashFlow;
import com.example.aplikasita.model.MonthlyIncome;
import com.example.aplikasita.model.MonthlySpending;

import java.util.List;

//SELECT
//        products.name,
//        sum(history.amount) AS [Amount]
//        FROM history
//        INNER JOIN products ON history.id_product = products.id_product
//        GROUP BY
//        products.name;

@Dao
public interface MonthlyDao {
//    @Query("SELECT SUM(spending_table.jumlah) AS spendingTotal," +
//            "SUM(income_table.jumlah) AS incomeTotal ," +
//            "spending_table.bulan_tahun AS dateYear " +
//            "FROM spending_table JOIN income_table ON spending_table.bulan_tahun=income_table.bulan_tahun " +
//            "GROUP BY spending_table.bulan_tahun")
//    LiveData<List<MonthlyCashFlow>> getMonthly();

//    @Query("SELECT SUM(jumlah) as totalIncome, bulan_tahun as monthYear FROM income_table GROUP BY bulan_tahun")
//    LiveData<List<MonthlyIncome>> getMonthlyIncome();

    @Query("SELECT SUM(jumlah) AS spendingTotal, bulan_tahun AS monthYear FROM spending_table GROUP BY bulan_tahun")
    LiveData<List<MonthlySpending>> getMonthlySpending();

}
