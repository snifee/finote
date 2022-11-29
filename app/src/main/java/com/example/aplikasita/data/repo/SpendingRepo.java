package com.example.aplikasita.data.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.dao.SpendingDao;
import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.entity.Spending;
import com.example.aplikasita.model.MonthlyCashFlow;

import java.util.List;

public class SpendingRepo {

    private SpendingDao spendingDao;
    private LiveData<List<Spending>> allSpending;

    public SpendingRepo(Application application){
        AppDatabase database = AppDatabase.getDB(application);
        spendingDao = database.spendingDao();

        allSpending = spendingDao.getAllSpending();
    }

    public void insert(Spending spending){
        new SpendingRepo.InsertSpendingAsyncTask(spendingDao).execute(spending);
    }

    public void update(Spending spending){
        new SpendingRepo.UpdateSpendingAsyncTask(spendingDao).execute(spending);
    }

    public void delete(Spending spending){
        new SpendingRepo.DeleteSpendingAsyncTask(spendingDao).execute(spending);
    }

    public void deleteAll(){
        new SpendingRepo.DeleteAllSpendingAsyncTask(spendingDao).execute();
    }

    public LiveData<List<Spending>> getAllSpending() {
        return allSpending;
    }


    private static class InsertSpendingAsyncTask extends AsyncTask<Spending, Void,Void> {
        private SpendingDao spendingDao;

        private InsertSpendingAsyncTask(SpendingDao spendingDao){
            this.spendingDao = spendingDao;
        }

        @Override
        protected Void doInBackground(Spending... spendings) {
            spendingDao.insert(spendings[0]);
            return null;
        }
    }

    private static class UpdateSpendingAsyncTask extends AsyncTask<Spending, Void,Void> {
        private SpendingDao spendingDao;

        private UpdateSpendingAsyncTask(SpendingDao spendingDao){
            this.spendingDao = spendingDao;
        }

        @Override
        protected Void doInBackground(Spending... spendings) {
            spendingDao.update(spendings[0]);
            return null;
        }
    }

    private static class DeleteSpendingAsyncTask extends AsyncTask<Spending, Void,Void> {
        private SpendingDao spendingDao;

        private DeleteSpendingAsyncTask(SpendingDao spendingDao){
            this.spendingDao = spendingDao;
        }

        @Override
        protected Void doInBackground(Spending... spendings) {
            spendingDao.delete(spendings[0]);
            return null;
        }
    }

    private static class DeleteAllSpendingAsyncTask extends AsyncTask<Void, Void,Void>{
        private SpendingDao spendingDao;

        private DeleteAllSpendingAsyncTask(SpendingDao spendingDao){
            this.spendingDao = spendingDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            spendingDao.deleteAllSpending();
            return null;
        }
    }


}
