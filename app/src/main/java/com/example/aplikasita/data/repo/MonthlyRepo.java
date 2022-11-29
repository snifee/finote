package com.example.aplikasita.data.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.dao.MonthlyDao;
import com.example.aplikasita.model.MonthlyCashFlow;

import java.util.List;

public class MonthlyRepo {
    private MonthlyDao monthlyDao;

    private LiveData<List<MonthlyCashFlow>> allMonth;

    public MonthlyRepo(Application application){
        AppDatabase database = AppDatabase.getDB(application);
        monthlyDao = database.monthlyDao();

        this.allMonth= monthlyDao.getMonthly();
    }

    public LiveData<List<MonthlyCashFlow>> getAllMonth() {
        return allMonth;
    }
}
