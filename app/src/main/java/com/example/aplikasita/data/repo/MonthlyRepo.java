package com.example.aplikasita.data.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.dao.MonthlyDao;
import com.example.aplikasita.model.MonthlyCashFlow;
import com.example.aplikasita.model.MonthlyIncome;
import com.example.aplikasita.model.MonthlySpending;

import java.util.List;

public class MonthlyRepo {
    private MonthlyDao monthlyDao;

//    private LiveData<List<MonthlyCashFlow>> allMonth;

    private LiveData<List<MonthlySpending>> allMonthSpening;
//    private LiveData<List<MonthlyIncome>> allMonthIncome;
    private LiveData<Long> sumofSpendingByMonth;

    public MonthlyRepo(Application application){
        AppDatabase database = AppDatabase.getDB(application);
        monthlyDao = database.monthlyDao();

        this.allMonthSpening = monthlyDao.getMonthlySpending();
//        this.allMonthIncome = monthlyDao.getMonthlyIncome();
    }


    public LiveData<List<MonthlySpending>> getAllMonthSpening() {
        return allMonthSpening;
    }

//    public LiveData<List<MonthlyIncome>> getAllMonthIncome() {
//        return allMonthIncome;
//    }

    public LiveData<Long> getSumofSpendingByMonth(String m) {
        this.sumofSpendingByMonth = monthlyDao.getSumSpendingByMonth(m);
        return sumofSpendingByMonth;
    }
}
