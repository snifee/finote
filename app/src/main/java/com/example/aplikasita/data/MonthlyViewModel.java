package com.example.aplikasita.data;

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
//    private LiveData<List<MonthlyCashFlow>> allMonthly;

    private LiveData<List<MonthlySpending>> allMonthlySpending;
//    private LiveData<List<MonthlyIncome>> allMonthlyIncome;
    private LiveData<Long> sumofSpendingByMonth;

    public MonthlyViewModel(@NonNull Application application) {
        super(application);
        this.monthlyRepo = new MonthlyRepo(application);
        this.allMonthlySpending = monthlyRepo.getAllMonthSpening();
//        this.allMonthlyIncome = monthlyRepo.getAllMonthIncome();
    }

//    public LiveData<List<MonthlyCashFlow>> getAllMonthly() {
//        return allMonthly;
//    }


    public LiveData<List<MonthlySpending>> getAllMonthlySpending() {
        return allMonthlySpending;
    }

//    public void setAllMonthlySpending(LiveData<List<MonthlySpending>> allMonthlySpending) {
//        this.allMonthlySpending = allMonthlySpending;
//    }

//    public LiveData<List<MonthlyIncome>> getAllMonthlyIncome() {
//        return allMonthlyIncome;
//    }

//    public void setAllMonthlyIncome(LiveData<List<MonthlyIncome>> allMonthlyIncome) {
//        this.allMonthlyIncome = allMonthlyIncome;
//    }

    public LiveData<Long> getSumofSpendingByMonth(String month) {
        this.sumofSpendingByMonth = monthlyRepo.getSumofSpendingByMonth(month);
        return sumofSpendingByMonth;
    }
}
