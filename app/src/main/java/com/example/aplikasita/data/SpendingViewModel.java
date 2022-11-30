package com.example.aplikasita.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.entity.Spending;
import com.example.aplikasita.data.repo.SpendingRepo;
import com.example.aplikasita.model.MonthlyCashFlow;

import java.util.List;

public class SpendingViewModel extends AndroidViewModel {
    private SpendingRepo spendingRepo;
    private LiveData<List<Spending>> allSpending;
    private LiveData<List<Spending>> allSpendingByMonth;
    private LiveData<Long> sumofSpendingByMonth;

    public SpendingViewModel(@NonNull Application application) {
        super(application);
        this.spendingRepo = new SpendingRepo(application);
        this.allSpending = spendingRepo.getAllSpending();
    }

    public void insert(Spending spending){
        spendingRepo.insert(spending);
    }

    public void update(Spending spending){
        spendingRepo.update(spending);
    }

    public void delete(Spending spending){
        spendingRepo.delete(spending);
    }

    public void deleteAll(){
        spendingRepo.deleteAll();
    }

    public LiveData<List<Spending>> getAllSpending() {
        return allSpending;
    }

    public LiveData<List<Spending>> getAllSpendingByMonth(String month) {
        this.allSpendingByMonth = spendingRepo.getAllSpendingByMonth(month);
        return allSpendingByMonth;
    }

//    public LiveData<Long> getSumofSpendingByMonth(String month) {
//        this.sumofSpendingByMonth = mo.getSumofSpendingByMonth(month);
//        return sumofSpendingByMonth;
//    }
}
