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
    private LiveData<List<MonthlySpending>> allMonthSpening;

    public MonthlyRepo(Application application){
        AppDatabase database = AppDatabase.getDB(application,"password");
        monthlyDao = database.monthlyDao();

        this.allMonthSpening = monthlyDao.getMonthlySpending();

    }


    public LiveData<List<MonthlySpending>> getAllMonthSpening() {
        return allMonthSpening;
    }



}
