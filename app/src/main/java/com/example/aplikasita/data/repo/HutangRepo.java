package com.example.aplikasita.data.repo;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.aplikasita.data.AppDatabase;
import com.example.aplikasita.data.dao.HutangDao;
import com.example.aplikasita.data.entity.Hutang;
import com.example.aplikasita.utils.CryptManager;
import com.example.aplikasita.utils.MyPreferences;

import java.util.List;

public class HutangRepo {

    private HutangDao hutangDao;
    private LiveData<List<Hutang>> allHutang;
    private String encryptedDBPassword,dbPassword,userPassword,currectPassword;


    public HutangRepo(Application application){

        encryptedDBPassword = MyPreferences.getSharedPreferenceDBKey(application);
        userPassword = MyPreferences.getSharedPreferencePassword(application);
        currectPassword = MyPreferences.getSharedPreferenceTemporaryPassword(application);

        dbPassword = CryptManager.aesDecryption(encryptedDBPassword,currectPassword);

        AppDatabase database = AppDatabase.getDB(application,dbPassword);
        hutangDao = database.hutangDao();

        allHutang = hutangDao.getAllHutang();


    }

    public void insert(Hutang hutang){
        new HutangRepo.InsertHutangAsyncTask(hutangDao).execute(hutang);
    }

    public void update(Hutang hutang){
        new HutangRepo.UpdateHutangAsyncTask(hutangDao).execute(hutang);
    }

    public void delete(Hutang hutang){
        new HutangRepo.DeleteHutangAsyncTask(hutangDao).execute(hutang);
    }


    public LiveData<List<Hutang>> getAllHutang() {
        return allHutang;
    }

    private static class InsertHutangAsyncTask extends AsyncTask<Hutang, Void,Void>{
        private HutangDao hutangDao;

        private InsertHutangAsyncTask(HutangDao hutangDao){
            this.hutangDao = hutangDao;
        }

        @Override
        protected Void doInBackground(Hutang... hutangs) {
            hutangDao.insert(hutangs[0]);
            return null;
        }
    }

    private static class UpdateHutangAsyncTask extends AsyncTask<Hutang, Void,Void>{
        private HutangDao hutangDao;

        private UpdateHutangAsyncTask(HutangDao hutangDao){
            this.hutangDao = hutangDao;
        }

        @Override
        protected Void doInBackground(Hutang... hutangs) {
            hutangDao.update(hutangs[0]);
            return null;
        }
    }

    private static class DeleteHutangAsyncTask extends AsyncTask<Hutang, Void,Void>{
        private HutangDao hutangDao;

        private DeleteHutangAsyncTask(HutangDao hutangDao){
            this.hutangDao = hutangDao;
        }

        @Override
        protected Void doInBackground(Hutang... hutangs) {
            hutangDao.delete(hutangs[0]);
            return null;
        }
    }

}
