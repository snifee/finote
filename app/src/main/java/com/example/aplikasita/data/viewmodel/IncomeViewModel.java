package com.example.aplikasita.data.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.entity.Pendapatan;
import com.example.aplikasita.data.repo.PemasukanRepo;

import java.util.List;

public class IncomeViewModel extends AndroidViewModel {
    private PemasukanRepo pemasukanRepo;
    private LiveData<List<Pendapatan>> allIncome;
    private LiveData<List<Pendapatan>> incomeByMonthYear;
    private LiveData<Long> sumofIncomeByMonth;

    public IncomeViewModel(@NonNull Application application) {
        super(application);
        pemasukanRepo = new PemasukanRepo(application);
        allIncome = pemasukanRepo.getAllIncome();
    }

    public void insert(Pendapatan pendapatan){
        pemasukanRepo.insert(pendapatan);
    }

    public void update(Pendapatan pendapatan){
        pemasukanRepo.update(pendapatan);
    }

    public void delete(Pendapatan pendapatan){
        pemasukanRepo.delete(pendapatan);
    }

    public void deleteAll(){
        pemasukanRepo.deleteAll();
    }

    public LiveData<List<Pendapatan>> getAllIncome() {
        return allIncome;
    }

    public LiveData<List<Pendapatan>> getIncomeByMonthYear(String monthYear) {
        incomeByMonthYear = pemasukanRepo.getIncomeByMonthYear(monthYear);
        return incomeByMonthYear;
    }

    public LiveData<Long> getSumofIncomeByMonth(String monthYear) {
        sumofIncomeByMonth = pemasukanRepo.getSumOfIncomeByMonth(monthYear);
        return sumofIncomeByMonth;
    }
}
