package com.example.aplikasita.data.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.entity.Kebutuhan;
import com.example.aplikasita.data.repo.KebutuhanRepo;

import java.util.List;

public class KebutuhanViewModel extends AndroidViewModel {
    private KebutuhanRepo kebutuhanRepo;
    private LiveData<List<Kebutuhan>> allBudget;
    private AppDatabase database;

    public KebutuhanViewModel(@NonNull Application application) {
        super(application);
        kebutuhanRepo = new KebutuhanRepo(application);
        allBudget = kebutuhanRepo.getAllBudget();
    }

    public void insert(Kebutuhan kebutuhan){
        kebutuhanRepo.insert(kebutuhan);
    }

    public void update(Kebutuhan kebutuhan){
        kebutuhanRepo.update(kebutuhan);
    }

    public void delete(Kebutuhan kebutuhan){
        kebutuhanRepo.delete(kebutuhan);
    }


    public LiveData<List<Kebutuhan>> getAllBudget() {
        return allBudget;
    }
}
