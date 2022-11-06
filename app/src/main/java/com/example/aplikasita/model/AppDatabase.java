package com.example.aplikasita.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.aplikasita.dao.IncomeDao;
import com.example.aplikasita.dao.SpendingDao;


@Database(entities = {Spending.class, Income.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SpendingDao spendingDao();

    public abstract IncomeDao incomeDao();
}
