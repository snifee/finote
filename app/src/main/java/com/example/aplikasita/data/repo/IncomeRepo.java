package com.example.aplikasita.data.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.dao.IncomeDao;
import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.entity.Income;
import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyPreferences;

import java.util.List;

public class IncomeRepo {

    private IncomeDao incomeDao;
    private LiveData<List<Income>> allIncome;
    private LiveData<List<Income>> incomeByMonthYear;
    private LiveData<Long> sumOfIncomeByMonth;
    private String encryptedDBPassword,dbPassword,userPassword;


    public  IncomeRepo(Application application){

        encryptedDBPassword = MyPreferences.getSharedPreferenceDBKey(application);
        userPassword = MyPreferences.getSharedPreferencePassword(application);

        dbPassword = CryptManager.decrypt(encryptedDBPassword,userPassword);

        AppDatabase database = AppDatabase.getDB(application,dbPassword);
        incomeDao = database.incomeDao();

        allIncome = incomeDao.getAllIncome();


    }

    public void insert(Income income){
        new InsertIncomeAsyncTask(incomeDao).execute(income);
    }

    public void update(Income income){
        new UpdateIncomeAsyncTask(incomeDao).execute(income);
    }

    public void delete(Income income){
        new DeleteIncomeAsyncTask(incomeDao).execute(income);
    }

    public void deleteAll(){
        new DeleteAllIncomeAsyncTask(incomeDao).execute();
    }

    public LiveData<List<Income>> getAllIncome(){
        return allIncome;
    }

    public LiveData<List<Income>> getIncomeByMonthYear(String monthYear) {
        incomeByMonthYear = incomeDao.getIncomeByYearMonth(monthYear);
        return incomeByMonthYear;
    }

    public LiveData<Long> getSumOfIncomeByMonth(String monthYear) {
        sumOfIncomeByMonth = incomeDao.getSumIncomeByMonth(monthYear);
        return sumOfIncomeByMonth;
    }

    private static class InsertIncomeAsyncTask extends AsyncTask<Income, Void,Void>{
        private IncomeDao incomeDao;

        private InsertIncomeAsyncTask(IncomeDao incomeDao){
            this.incomeDao = incomeDao;
        }

        @Override
        protected Void doInBackground(Income... incomes) {
            incomeDao.insert(incomes[0]);
            return null;
        }
    }

    private static class UpdateIncomeAsyncTask extends AsyncTask<Income, Void,Void>{
        private IncomeDao incomeDao;

        private UpdateIncomeAsyncTask(IncomeDao incomeDao){
            this.incomeDao = incomeDao;
        }

        @Override
        protected Void doInBackground(Income... incomes) {
            incomeDao.update(incomes[0]);
            return null;
        }
    }

    private static class DeleteIncomeAsyncTask extends AsyncTask<Income, Void,Void>{
        private IncomeDao incomeDao;

        private DeleteIncomeAsyncTask(IncomeDao incomeDao){
            this.incomeDao = incomeDao;
        }

        @Override
        protected Void doInBackground(Income... incomes) {
            incomeDao.delete(incomes[0]);
            return null;
        }
    }

    private static class DeleteAllIncomeAsyncTask extends AsyncTask<Void, Void,Void>{
        private IncomeDao incomeDao;

        private DeleteAllIncomeAsyncTask(IncomeDao incomeDao){
            this.incomeDao = incomeDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            incomeDao.deleteAllIncome();
            return null;
        }
    }

}
