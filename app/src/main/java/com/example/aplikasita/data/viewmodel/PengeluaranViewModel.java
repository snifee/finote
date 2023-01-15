package com.example.aplikasita.data.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.entity.Pengeluaran;
import com.example.aplikasita.data.repo.PengeluaranRepo;

import java.util.List;

public class PengeluaranViewModel extends AndroidViewModel {
    private PengeluaranRepo pengeluaranRepo;
    private LiveData<List<Pengeluaran>> allSpending;
    private LiveData<List<Pengeluaran>> allSpendingByMonth;
    private LiveData<Long> sumofSpendingByMonth;

    public PengeluaranViewModel(@NonNull Application application) {
        super(application);
        this.pengeluaranRepo = new PengeluaranRepo(application);
        this.allSpending = pengeluaranRepo.getAllSpending();
    }

    public void insert(Pengeluaran pengeluaran){
        pengeluaranRepo.insert(pengeluaran);
    }

    public void update(Pengeluaran pengeluaran){
        pengeluaranRepo.update(pengeluaran);
    }

    public void delete(Pengeluaran pengeluaran){
        pengeluaranRepo.delete(pengeluaran);
    }

    public void deleteAll(){
        pengeluaranRepo.deleteAll();
    }

    public LiveData<List<Pengeluaran>> getAllSpending() {
        return allSpending;
    }

    public LiveData<List<Pengeluaran>> getAllSpendingByMonth(String month) {
        this.allSpendingByMonth = pengeluaranRepo.getAllSpendingByMonth(month);
        return allSpendingByMonth;
    }

    public LiveData<Long> getSumofSpendingByMonth(String month) {
        this.sumofSpendingByMonth = pengeluaranRepo.getSumofSpendingByMonth(month);
        return sumofSpendingByMonth;
    }
}
