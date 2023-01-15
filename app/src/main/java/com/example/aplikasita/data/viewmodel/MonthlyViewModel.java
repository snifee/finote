package com.example.aplikasita.data.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.repo.MonthlyRepo;
import com.example.aplikasita.dto.MonthlyIncome;
import com.example.aplikasita.dto.MonthlySpending;

import java.util.List;

public class MonthlyViewModel extends AndroidViewModel {
    private MonthlyRepo monthlyRepo;

    private LiveData<List<MonthlySpending>> allMonthlySpending;
    private LiveData<List<MonthlyIncome>> allMonthlyIncome;

    public MonthlyViewModel(@NonNull Application application) {
        super(application);
        this.monthlyRepo = new MonthlyRepo(application);
        this.allMonthlySpending = monthlyRepo.getAllMonthSpening();
        this.allMonthlyIncome = monthlyRepo.getAllMonthIncome();
    }

    public LiveData<List<MonthlySpending>> getAllMonthlySpending() {
        return allMonthlySpending;
    }
    public LiveData<List<MonthlyIncome>> getAllMonthlyIncome() {
        return allMonthlyIncome;
    }
}
