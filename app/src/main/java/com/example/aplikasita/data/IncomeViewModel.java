package com.example.aplikasita.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.entity.Income;
import com.example.aplikasita.data.repo.IncomeRepo;

import java.util.List;

public class IncomeViewModel extends AndroidViewModel {
    private IncomeRepo incomeRepo;
    private LiveData<List<Income>> allIncome;

    public IncomeViewModel(@NonNull Application application) {
        super(application);
        incomeRepo = new IncomeRepo(application);
        allIncome = incomeRepo.getAllIncome();
    }

    public void insert(Income income){
        incomeRepo.insert(income);
    }

    public void update(Income income){
        incomeRepo.update(income);
    }

    public void delete(Income income){
        incomeRepo.delete(income);
    }

    public void deleteAll(){
        incomeRepo.deleteAll();
    }

    public LiveData<List<Income>> getAllIncome() {
        return allIncome;
    }
}