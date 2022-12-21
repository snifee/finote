package com.example.aplikasita.data.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.dao.SpendingDao;
import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.entity.Spending;
import com.example.aplikasita.model.MonthlyCashFlow;
import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyPreferences;

import java.util.List;

public class SpendingRepo {

    private SpendingDao spendingDao;
    private LiveData<List<Spending>> allSpending;
    private LiveData<List<Spending>> allSpendingByMonth;
    private LiveData<Long> sumofSpendingByMonth;
    private String encryptedDBPassword,dbPassword,userPassword;

    public SpendingRepo(Application application){

        encryptedDBPassword = MyPreferences.getSharedPreferenceDBKey(application);
        userPassword = MyPreferences.getSharedPreferencePassword(application);

        dbPassword = CryptManager.decrypt(encryptedDBPassword,userPassword);

        AppDatabase database = AppDatabase.getDB(application,dbPassword);
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

    public LiveData<List<Spending>> getAllSpendingByMonth(String month) {
        allSpendingByMonth = spendingDao.getAllSpendingByMonth(month);
        return allSpendingByMonth;
    }

    public LiveData<Long> getSumofSpendingByMonth(String m) {
        this.sumofSpendingByMonth = spendingDao.getSumSpendingByMonth(m);
        return sumofSpendingByMonth;
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
