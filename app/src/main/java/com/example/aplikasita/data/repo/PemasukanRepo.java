package com.example.aplikasita.data.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.dao.PendapatanDao;
import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.entity.Pendapatan;
import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyPreferences;

import java.util.List;

public class PemasukanRepo {

    private PendapatanDao pendapatanDao;
    private LiveData<List<Pendapatan>> allIncome;
    private LiveData<List<Pendapatan>> incomeByMonthYear;
    private LiveData<Long> sumOfIncomeByMonth;
    private String encryptedDBPassword,dbPassword,userPassword,currectPassword;


    public PemasukanRepo(Application application){

        encryptedDBPassword = MyPreferences.getSharedPreferenceDBKey(application);
        userPassword = MyPreferences.getSharedPreferencePassword(application);
        currectPassword = MyPreferences.getSharedPreferenceTemporaryPassword(application);

        dbPassword = CryptManager.aesDecryption(encryptedDBPassword,currectPassword);

        AppDatabase database = AppDatabase.getDB(application,dbPassword);
        pendapatanDao = database.pemasukanDao();

        allIncome = pendapatanDao.getAllIncome();


    }

    public void insert(Pendapatan pendapatan){
        new InsertIncomeAsyncTask(pendapatanDao).execute(pendapatan);
    }

    public void update(Pendapatan pendapatan){
        new UpdateIncomeAsyncTask(pendapatanDao).execute(pendapatan);
    }

    public void delete(Pendapatan pendapatan){
        new DeleteIncomeAsyncTask(pendapatanDao).execute(pendapatan);
    }

    public void deleteAll(){
        new DeleteAllIncomeAsyncTask(pendapatanDao).execute();
    }

    public LiveData<List<Pendapatan>> getAllIncome(){
        return allIncome;
    }

    public LiveData<List<Pendapatan>> getIncomeByMonthYear(String monthYear) {
        incomeByMonthYear = pendapatanDao.getIncomeByYearMonth(monthYear);
        return incomeByMonthYear;
    }

    public LiveData<Long> getSumOfIncomeByMonth(String monthYear) {
        sumOfIncomeByMonth = pendapatanDao.getSumIncomeByMonth(monthYear);
        return sumOfIncomeByMonth;
    }

    private static class InsertIncomeAsyncTask extends AsyncTask<Pendapatan, Void,Void>{
        private PendapatanDao pendapatanDao;

        private InsertIncomeAsyncTask(PendapatanDao pendapatanDao){
            this.pendapatanDao = pendapatanDao;
        }

        @Override
        protected Void doInBackground(Pendapatan... pendapatans) {
            pendapatanDao.insert(pendapatans[0]);
            return null;
        }
    }

    private static class UpdateIncomeAsyncTask extends AsyncTask<Pendapatan, Void,Void>{
        private PendapatanDao pendapatanDao;

        private UpdateIncomeAsyncTask(PendapatanDao pendapatanDao){
            this.pendapatanDao = pendapatanDao;
        }

        @Override
        protected Void doInBackground(Pendapatan... pendapatans) {
            pendapatanDao.update(pendapatans[0]);
            return null;
        }
    }

    private static class DeleteIncomeAsyncTask extends AsyncTask<Pendapatan, Void,Void>{
        private PendapatanDao pendapatanDao;

        private DeleteIncomeAsyncTask(PendapatanDao pendapatanDao){
            this.pendapatanDao = pendapatanDao;
        }

        @Override
        protected Void doInBackground(Pendapatan... pendapatans) {
            pendapatanDao.delete(pendapatans[0]);
            return null;
        }
    }

    private static class DeleteAllIncomeAsyncTask extends AsyncTask<Void, Void,Void>{
        private PendapatanDao pendapatanDao;

        private DeleteAllIncomeAsyncTask(PendapatanDao pendapatanDao){
            this.pendapatanDao = pendapatanDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            pendapatanDao.deleteAllIncome();
            return null;
        }
    }

}
