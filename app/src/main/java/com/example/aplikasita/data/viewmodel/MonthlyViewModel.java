package com.example.aplikasita.data.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.repo.MonthlyRepo;
import com.example.aplikasita.model.MonthlyCashFlow;
import com.example.aplikasita.model.MonthlyIncome;
import com.example.aplikasita.model.MonthlySpending;

import java.util.List;

public class MonthlyViewModel extends AndroidViewModel {
    private MonthlyRepo monthlyRepo;

    private LiveData<List<MonthlySpending>> allMonthlySpending;

    public MonthlyViewModel(@NonNull Application application) {
        super(application);
        this.monthlyRepo = new MonthlyRepo(application);
        this.allMonthlySpending = monthlyRepo.getAllMonthSpening();
    }

    public LiveData<List<MonthlySpending>> getAllMonthlySpending() {
        return allMonthlySpending;
    }

}
