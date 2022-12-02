package com.example.aplikasita.data.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.entity.Budget;
import com.example.aplikasita.data.entity.Income;
import com.example.aplikasita.data.repo.BudgetRepo;
import com.example.aplikasita.data.repo.IncomeRepo;

import java.util.List;

public class BudgetViewModel extends AndroidViewModel {
    private BudgetRepo budgetRepo;
    private LiveData<List<Budget>> allBudget;

    public BudgetViewModel(@NonNull Application application) {
        super(application);
        budgetRepo = new BudgetRepo(application);
        allBudget = budgetRepo.getAllBudget();
    }

    public void insert(Budget budget){
        budgetRepo.insert(budget);
    }

    public void update(Budget budget){
        budgetRepo.update(budget);
    }

    public void delete(Budget budget){
        budgetRepo.delete(budget);
    }


    public LiveData<List<Budget>> getAllBudget() {
        return allBudget;
    }
}
