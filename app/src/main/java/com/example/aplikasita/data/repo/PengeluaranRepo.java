package com.example.aplikasita.data.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.dao.PengeluaranDao;
import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.entity.Pengeluaran;
import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyPreferences;

import java.util.List;

public class PengeluaranRepo {

    private PengeluaranDao pengeluaranDao;
    private LiveData<List<Pengeluaran>> allSpending;
    private LiveData<List<Pengeluaran>> allSpendingByMonth;
    private LiveData<Long> sumofSpendingByMonth;

    public PengeluaranRepo(Application application){

        AppDatabase database = AppDatabase.getDB(application);
        pengeluaranDao = database.pengeluaranDao();

        allSpending = pengeluaranDao.getAllSpending();
    }

    public void insert(Pengeluaran pengeluaran){
        new PengeluaranRepo.InsertSpendingAsyncTask(pengeluaranDao).execute(pengeluaran);
    }

    public void update(Pengeluaran pengeluaran){
        new PengeluaranRepo.UpdateSpendingAsyncTask(pengeluaranDao).execute(pengeluaran);
    }

    public void delete(Pengeluaran pengeluaran){
        new PengeluaranRepo.DeleteSpendingAsyncTask(pengeluaranDao).execute(pengeluaran);
    }

    public void deleteAll(){
        new PengeluaranRepo.DeleteAllSpendingAsyncTask(pengeluaranDao).execute();
    }

    public LiveData<List<Pengeluaran>> getAllSpending() {
        return allSpending;
    }

    public LiveData<List<Pengeluaran>> getAllSpendingByMonth(String month) {
        allSpendingByMonth = pengeluaranDao.getAllSpendingByMonth(month);
        return allSpendingByMonth;
    }

    public LiveData<Long> getSumofSpendingByMonth(String m) {
        this.sumofSpendingByMonth = pengeluaranDao.getSumSpendingByMonth(m);
        return sumofSpendingByMonth;
    }

    private static class InsertSpendingAsyncTask extends AsyncTask<Pengeluaran, Void,Void> {
        private PengeluaranDao pengeluaranDao;

        private InsertSpendingAsyncTask(PengeluaranDao pengeluaranDao){
            this.pengeluaranDao = pengeluaranDao;
        }

        @Override
        protected Void doInBackground(Pengeluaran... pengeluarans) {
            pengeluaranDao.insert(pengeluarans[0]);
            return null;
        }
    }

    private static class UpdateSpendingAsyncTask extends AsyncTask<Pengeluaran, Void,Void> {
        private PengeluaranDao pengeluaranDao;

        private UpdateSpendingAsyncTask(PengeluaranDao pengeluaranDao){
            this.pengeluaranDao = pengeluaranDao;
        }

        @Override
        protected Void doInBackground(Pengeluaran... pengeluarans) {
            pengeluaranDao.update(pengeluarans[0]);
            return null;
        }
    }

    private static class DeleteSpendingAsyncTask extends AsyncTask<Pengeluaran, Void,Void> {
        private PengeluaranDao pengeluaranDao;

        private DeleteSpendingAsyncTask(PengeluaranDao pengeluaranDao){
            this.pengeluaranDao = pengeluaranDao;
        }

        @Override
        protected Void doInBackground(Pengeluaran... pengeluarans) {
            pengeluaranDao.delete(pengeluarans[0]);
            return null;
        }
    }

    private static class DeleteAllSpendingAsyncTask extends AsyncTask<Void, Void,Void>{
        private PengeluaranDao pengeluaranDao;

        private DeleteAllSpendingAsyncTask(PengeluaranDao pengeluaranDao){
            this.pengeluaranDao = pengeluaranDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            pengeluaranDao.deleteAllSpending();
            return null;
        }
    }


}
