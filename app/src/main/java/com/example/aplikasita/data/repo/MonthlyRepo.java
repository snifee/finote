package com.example.aplikasita.data.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.dao.MonthlyDao;
import com.example.aplikasita.dto.MonthlyIncome;
import com.example.aplikasita.dto.MonthlySpending;
import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyPreferences;

import java.util.List;

public class MonthlyRepo {
    private MonthlyDao monthlyDao;
    private LiveData<List<MonthlySpending>> allMonthSpening;
    private LiveData<List<MonthlyIncome>> allMonthIncome;

    public MonthlyRepo(Application application){

        AppDatabase database = AppDatabase.getInstance();
        monthlyDao = database.monthlyDao();

        this.allMonthSpening = monthlyDao.getMonthlySpending();
        this.allMonthIncome = monthlyDao.getMonthlyIncome();

    }


    public LiveData<List<MonthlySpending>> getAllMonthSpening() {
        return allMonthSpening;
    }

    public LiveData<List<MonthlyIncome>> getAllMonthIncome() {
        return allMonthIncome;
    }



}
