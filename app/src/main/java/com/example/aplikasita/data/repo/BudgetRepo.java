package com.example.aplikasita.data.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.dao.BudgetDao;
import com.example.aplikasita.data.dao.IncomeDao;
import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.entity.Budget;
import com.example.aplikasita.data.entity.Income;
import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyPreferences;
import com.example.aplikasita.utils.MyStringUtils;

import java.util.List;

public class BudgetRepo {
    private BudgetDao budgetDao;
    private LiveData<List<Budget>> allBudget;
    private String encryptedDBPassword,dbPassword,userPassword;

    public  BudgetRepo(Application application){

        encryptedDBPassword = MyPreferences.getSharedPreferenceDBKey(application);
        userPassword = MyPreferences.getSharedPreferencePassword(application);

        dbPassword = CryptManager.decrypt(encryptedDBPassword,userPassword);

        AppDatabase database = AppDatabase.getDB(application,dbPassword);
        budgetDao = database.budgetDao();
        allBudget = budgetDao.getAllBudget();

    }

    public void insert(Budget budget){
        new BudgetRepo.InsertBudgetAsyncTask(budgetDao).execute(budget);
    }

    public void update(Budget budget){
        new BudgetRepo.UpdateBudgetAsyncTask(budgetDao).execute(budget);
    }

    public void delete(Budget budget){
        new BudgetRepo.DeleteBudgetAsyncTask(budgetDao).execute(budget);
    }

    public LiveData<List<Budget>> getAllBudget(){
        return allBudget;
    }

    private static class InsertBudgetAsyncTask extends AsyncTask<Budget, Void,Void> {
        private BudgetDao budgetDao;

        private InsertBudgetAsyncTask(BudgetDao budgetDao){
            this.budgetDao = budgetDao;
        }

        @Override
        protected Void doInBackground(Budget... budgets) {
            budgetDao.insert(budgets[0]);
            return null;
        }
    }

    private static class UpdateBudgetAsyncTask extends AsyncTask<Budget, Void,Void> {
        private BudgetDao budgetDao;

        private UpdateBudgetAsyncTask(BudgetDao budgetDao){
            this.budgetDao = budgetDao;
        }

        @Override
        protected Void doInBackground(Budget... budgets) {
            budgetDao.update(budgets[0]);
            return null;
        }
    }

    private static class DeleteBudgetAsyncTask extends AsyncTask<Budget, Void,Void> {
        private BudgetDao budgetDao;

        private DeleteBudgetAsyncTask(BudgetDao budgetDao){
            this.budgetDao = budgetDao;
        }

        @Override
        protected Void doInBackground(Budget... budgets) {
            budgetDao.delete(budgets[0]);
            return null;
        }
    }


}
