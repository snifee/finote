package com.example.aplikasita.data.entity;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aplikasita.data.dao.IncomeDao;
import com.example.aplikasita.data.dao.SpendingDao;


@Database(entities = {Spending.class, Income.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SpendingDao spendingDao();

    public abstract IncomeDao incomeDao();

    private static volatile AppDatabase appDatabase;

    static AppDatabase getDB(final Context context){
        if (appDatabase == null){
            synchronized (AppDatabase.class){
                if (appDatabase == null){
                    appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "finote_db").build();
                }
            }
        }
        return appDatabase;
    };

}
