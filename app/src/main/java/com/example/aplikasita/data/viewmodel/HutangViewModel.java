package com.example.aplikasita.data.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.entity.Hutang;
import com.example.aplikasita.data.repo.HutangRepo;

import java.util.List;

public class HutangViewModel extends AndroidViewModel {
    private HutangRepo hutangRepo;
    private LiveData<List<Hutang>> allHutang;
    private AppDatabase database;

    public HutangViewModel(@NonNull Application application) {
        super(application);
        hutangRepo = new HutangRepo(application);
        allHutang = hutangRepo.getAllHutang();
    }

    public void insert(Hutang hutang){
        hutangRepo.insert(hutang);
    }

    public void update(Hutang hutang){
        hutangRepo.update(hutang);
    }

    public void delete(Hutang hutang){
        hutangRepo.delete(hutang);
    }


    public LiveData<List<Hutang>> getAllBudget() {
        return allHutang;
    }
}
