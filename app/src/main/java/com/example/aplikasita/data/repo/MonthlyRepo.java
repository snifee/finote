package com.example.aplikasita.data.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.dao.MonthlyDao;
import com.example.aplikasita.dto.MonthlySpending;
import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyPreferences;

import java.util.List;

public class MonthlyRepo {
    private MonthlyDao monthlyDao;
    private LiveData<List<MonthlySpending>> allMonthSpening;
    private String encryptedDBPassword,dbPassword,userPassword;

    public MonthlyRepo(Application application){

        encryptedDBPassword = MyPreferences.getSharedPreferenceDBKey(application);
        userPassword = MyPreferences.getSharedPreferencePassword(application);

        dbPassword = CryptManager.decrypt(encryptedDBPassword,userPassword);

        AppDatabase database = AppDatabase.getDB(application,dbPassword);
        monthlyDao = database.monthlyDao();

        this.allMonthSpening = monthlyDao.getMonthlySpending();

    }


    public LiveData<List<MonthlySpending>> getAllMonthSpening() {
        return allMonthSpening;
    }



}
