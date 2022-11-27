package com.example.aplikasita.data.entity;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.aplikasita.data.DateConverter;
import com.example.aplikasita.data.dao.IncomeDao;
import com.example.aplikasita.data.dao.SpendingDao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Database(entities = {Spending.class, Income.class}, version = 4)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract SpendingDao spendingDao();

    public abstract IncomeDao incomeDao();

    private static volatile AppDatabase appDatabase;

    public static AppDatabase getDB(final Context context){
        if (appDatabase == null){
            synchronized (AppDatabase.class){
                if (appDatabase == null){
                    appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "finote_db")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
                }
            }
        }
        return appDatabase;
    };


    private  static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(appDatabase).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private IncomeDao incomeDao;

        private PopulateDbAsyncTask(AppDatabase db){
            incomeDao = db.incomeDao();
        }


        @Override
        protected Void doInBackground(Void... voids) {

            incomeDao.insert(new Income("123", 230000,new Date(),"beli rumah"));
            incomeDao.insert(new Income("123", 10000,new Date(),"beli saham"));
            return null;
        }
    }



}
