package com.example.aplikasita.data.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.entity.Keperluan;
import com.example.aplikasita.data.repo.KeperluanRepo;

import java.util.List;

public class BudgetViewModel extends AndroidViewModel {
    private KeperluanRepo keperluanRepo;
    private LiveData<List<Keperluan>> allBudget;
    private AppDatabase database;

    public BudgetViewModel(@NonNull Application application) {
        super(application);
        keperluanRepo = new KeperluanRepo(application);
        allBudget = keperluanRepo.getAllBudget();
    }

    public void insert(Keperluan keperluan){
        keperluanRepo.insert(keperluan);
    }

    public void update(Keperluan keperluan){
        keperluanRepo.update(keperluan);
    }

    public void delete(Keperluan keperluan){
        keperluanRepo.delete(keperluan);
    }


    public LiveData<List<Keperluan>> getAllBudget() {
        return allBudget;
    }
}
