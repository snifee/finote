package com.example.aplikasita.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.entity.Spending;
import com.example.aplikasita.data.repo.MonthlyRepo;
import com.example.aplikasita.data.repo.SpendingRepo;
import com.example.aplikasita.model.MonthlyCashFlow;

import java.util.List;

public class MonthlyViewMode extends AndroidViewModel {
    private MonthlyRepo monthlyRepo;
    private LiveData<List<MonthlyCashFlow>> allMonthly;

    public MonthlyViewMode(@NonNull Application application) {
        super(application);
        this.monthlyRepo = new MonthlyRepo(application);
        this.allMonthly =  monthlyRepo.getAllMonth();
    }

    public LiveData<List<MonthlyCashFlow>> getAllMonthly() {
        return allMonthly;
    }
}
