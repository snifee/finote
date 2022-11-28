package com.example.aplikasita.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.entity.Income;
import com.example.aplikasita.data.entity.Spending;
import com.example.aplikasita.data.repo.IncomeRepo;
import com.example.aplikasita.data.repo.SpendingRepo;
import com.example.aplikasita.model.SpendingGroupByModel;

import java.util.List;

public class SpendingViewModel extends AndroidViewModel {
    private SpendingRepo spendingRepo;
    private LiveData<List<Spending>> allSpending;
    private LiveData<List<SpendingGroupByModel>> countSpendingByMonth;

    public SpendingViewModel(@NonNull Application application) {
        super(application);
        this.spendingRepo = new SpendingRepo(application);
        this.allSpending = spendingRepo.getAllSpending();
        this.countSpendingByMonth =  spendingRepo.getCountSpendingByMonth();
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

    public LiveData<List<SpendingGroupByModel>> getCountSpendingByMonth() {
        return countSpendingByMonth;
    }
}
