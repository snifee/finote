package com.example.aplikasita.data.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.dao.KeperluanDao;
import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.entity.Keperluan;
import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyPreferences;

import java.util.List;

public class KeperluanRepo {
    private KeperluanDao keperluanDao;
    private LiveData<List<Keperluan>> allBudget;

    public KeperluanRepo(Application application){

        AppDatabase database = AppDatabase.getDB(application);
        keperluanDao = database.keperluanDao();
        allBudget = keperluanDao.getAllBudget();

    }

    public void insert(Keperluan keperluan){
        new KeperluanRepo.InsertBudgetAsyncTask(keperluanDao).execute(keperluan);
    }

    public void update(Keperluan keperluan){
        new KeperluanRepo.UpdateBudgetAsyncTask(keperluanDao).execute(keperluan);
    }

    public void delete(Keperluan keperluan){
        new KeperluanRepo.DeleteBudgetAsyncTask(keperluanDao).execute(keperluan);
    }

    public LiveData<List<Keperluan>> getAllBudget(){
        return allBudget;
    }

    private static class InsertBudgetAsyncTask extends AsyncTask<Keperluan, Void,Void> {
        private KeperluanDao keperluanDao;

        private InsertBudgetAsyncTask(KeperluanDao keperluanDao){
            this.keperluanDao = keperluanDao;
        }

        @Override
        protected Void doInBackground(Keperluan... keperluans) {
            keperluanDao.insert(keperluans[0]);
            return null;
        }
    }

    private static class UpdateBudgetAsyncTask extends AsyncTask<Keperluan, Void,Void> {
        private KeperluanDao keperluanDao;

        private UpdateBudgetAsyncTask(KeperluanDao keperluanDao){
            this.keperluanDao = keperluanDao;
        }

        @Override
        protected Void doInBackground(Keperluan... keperluans) {
            keperluanDao.update(keperluans[0]);
            return null;
        }
    }

    private static class DeleteBudgetAsyncTask extends AsyncTask<Keperluan, Void,Void> {
        private KeperluanDao keperluanDao;

        private DeleteBudgetAsyncTask(KeperluanDao keperluanDao){
            this.keperluanDao = keperluanDao;
        }

        @Override
        protected Void doInBackground(Keperluan... keperluans) {
            keperluanDao.delete(keperluans[0]);
            return null;
        }
    }


}
