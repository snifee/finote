package com.example.aplikasita.data.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.dao.KebutuhanDao;
import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.entity.Kebutuhan;
import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyPreferences;

import java.util.List;

public class KebutuhanRepo {
    private KebutuhanDao kebutuhanDao;
    private LiveData<List<Kebutuhan>> allBudget;

    private List<Integer> allIdKebutuhan;

    public KebutuhanRepo(Application application){

        AppDatabase database = AppDatabase.getInstance();
        kebutuhanDao = database.keperluanDao();
        allBudget = kebutuhanDao.getAllBudget();

    }

    public void insert(Kebutuhan kebutuhan){
        new KebutuhanRepo.InsertBudgetAsyncTask(kebutuhanDao).execute(kebutuhan);
    }

    public void update(Kebutuhan kebutuhan){
        new KebutuhanRepo.UpdateBudgetAsyncTask(kebutuhanDao).execute(kebutuhan);
    }

    public void delete(Kebutuhan kebutuhan){
        new KebutuhanRepo.DeleteBudgetAsyncTask(kebutuhanDao).execute(kebutuhan);
    }

    public LiveData<List<Kebutuhan>> getAllBudget(){
        return allBudget;
    }

    public List<Integer> getAllIdKebutuhan() {
        return allIdKebutuhan;
    }

    private static class InsertBudgetAsyncTask extends AsyncTask<Kebutuhan, Void,Void> {
        private KebutuhanDao kebutuhanDao;

        private InsertBudgetAsyncTask(KebutuhanDao kebutuhanDao){
            this.kebutuhanDao = kebutuhanDao;
        }

        @Override
        protected Void doInBackground(Kebutuhan... kebutuhans) {
            kebutuhanDao.insert(kebutuhans[0]);
            return null;
        }
    }

    private static class UpdateBudgetAsyncTask extends AsyncTask<Kebutuhan, Void,Void> {
        private KebutuhanDao kebutuhanDao;

        private UpdateBudgetAsyncTask(KebutuhanDao kebutuhanDao){
            this.kebutuhanDao = kebutuhanDao;
        }

        @Override
        protected Void doInBackground(Kebutuhan... kebutuhans) {
            kebutuhanDao.update(kebutuhans[0]);
            return null;
        }
    }

    private static class DeleteBudgetAsyncTask extends AsyncTask<Kebutuhan, Void,Void> {
        private KebutuhanDao kebutuhanDao;

        private DeleteBudgetAsyncTask(KebutuhanDao kebutuhanDao){
            this.kebutuhanDao = kebutuhanDao;
        }

        @Override
        protected Void doInBackground(Kebutuhan... kebutuhans) {
            kebutuhanDao.delete(kebutuhans[0]);
            return null;
        }
    }


}
